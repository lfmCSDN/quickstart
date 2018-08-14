package com.ty.tybs.web.service.impl;


import com.ty.tybs.web.entity.po.CardBaseInfo;
import com.ty.tybs.web.entity.po.RsaPwdInfo;
import com.ty.tybs.web.entity.po.TransListInfo;
import com.ty.tybs.web.entity.po.UserBaseInfo;
import com.ty.tybs.web.entity.qo.TransListInfoQo;
import com.ty.tybs.web.entity.vo.CardBaseInfoVo;
import com.ty.tybs.web.entity.vo.TransListInfoVo;
import com.ty.tybs.web.mapper.CardBaseInfoMapper;
import com.ty.tybs.web.mapper.RsaPwdInfoMapper;
import com.ty.tybs.web.mapper.TransListMapper;
import com.ty.tybs.web.mapper.UserBaseInfoMapper;
import com.ty.tybs.web.service.AcctService;

import com.ty.tybs.web.util.DateUtils;
import com.ty.tybs.web.util.Md5Util;
import com.ty.tybs.web.util.RSAUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * User:LFM
 * Date:2018/4/4 0004
 */
@Service
@Transactional
public class AcctServiceImpl implements AcctService {

    @Autowired
    private CardBaseInfoMapper cardBaseInfoMapper;

    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper;

    @Autowired
    private TransListMapper transListMapper;

    @Autowired
    private RsaPwdInfoMapper rsaPwdInfoMapper;

    /*存款*/
    @Override
    public String bankSaving(CardBaseInfoVo cardBaseInfoVo) {
        CardBaseInfo cardBaseInfo;
        cardBaseInfo = cardBaseInfoMapper.getObjectByCardId(cardBaseInfoVo.getCardId());
        if (cardBaseInfo == null) {
            return "银行卡号错误";
        }
        switch (cardBaseInfo.getStat()) {
            case "挂失":
                return "存款失败，该银行卡处于挂失状态";
            case "注销":
                return "存款失败，该银行卡已注销";
            case "冻结":
                return "存款失败，该银行卡处于冻结状态";
        }
        cardBaseInfoMapper.receipt(cardBaseInfoVo.getCardId(), cardBaseInfoVo.getAmount());

        /*添加存款交易明细*/
        String transListInfoId = UUID.randomUUID().toString();
        String serialNumber = DateUtils.getOrderOID();
        String merchandiseDate = DateUtils.dataToStr1(new Date());
        transListMapper.addTransList(transListInfoId, cardBaseInfo.getCardBaseInfoId(), serialNumber, cardBaseInfoVo.getAmount(), "存款", merchandiseDate);

        return "存款成功";
    }

    /*转账*/
    @Override
    public String transfer(CardBaseInfoVo cardBaseInfoVo) {
        String pwd = null;
        UserBaseInfo receiptMan = null;
        CardBaseInfo payCard = cardBaseInfoMapper.getObjectByCardId(cardBaseInfoVo.getPayCardId());
        if (payCard == null) {
            return "付款账号不存在，请重新输入";
        } else if (!payCard.getCardType().equals("借记卡")) {
            return "付款账号的类型为：" + payCard.getCardType() + "，该类型卡，不能进行转账操作！";
        }
        CardBaseInfo receiptCard = cardBaseInfoMapper.getObjectByCardId(cardBaseInfoVo.getReceiptCardId());
        if (receiptCard == null) {
            return "收款账号不存在，请重新输入";
        } else if (!receiptCard.getCardType().equals("借记卡")) {
            return "收款账号的类型为：" + receiptCard.getCardType() + "，该类型卡，不能进行转账操作！";
        } else {
            receiptMan = userBaseInfoMapper.getObjectByPrimarykey(receiptCard.getUserBaseInfoId());
            if (!cardBaseInfoVo.getReceiptName().equals(receiptMan.getUserName()))
                return "收款账号与收款人不匹配，请再次确认";
        }
        try {
            pwd = Md5Util.encodeByMd5(cardBaseInfoVo.getTransPwd());
            cardBaseInfoVo.setTransPwd(pwd);
            if (!cardBaseInfoVo.getTransPwd().equals(payCard.getTransPwd())) {
                return "转账失败,银行卡密码错误";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        switch (payCard.getStat()) {
            case "挂失":
                return "转账失败，付款账号处于挂失状态";
            case "注销":
                return "转账失败，付款账号已注销";
            case "冻结":
                return "转账失败，付款账号处于冻结状态";
        }

        switch (receiptCard.getStat()) {
            case "挂失":
                return "转账失败，收款账号处于挂失状态";
            case "注销":
                return "转账失败，收款账号已注销";
            case "冻结":
                return "转账失败，收款账号处于冻结状态";
        }

        if (payCard.getOveage().compareTo(cardBaseInfoVo.getAmount()) == -1) {
            return "付款账号余额不足";
        }

        cardBaseInfoMapper.payment(payCard.getCardId(), cardBaseInfoVo.getAmount());
        cardBaseInfoMapper.receipt(receiptCard.getCardId(), cardBaseInfoVo.getAmount());

        /*添加转账明细*/
        String transListInfoId = UUID.randomUUID().toString();
        String serialNumber = DateUtils.getOrderOID();
        String merchandiseDate = DateUtils.dataToStr1(new Date());
        transListMapper.addTransList(transListInfoId, payCard.getCardBaseInfoId(), serialNumber, cardBaseInfoVo.getAmount(), "转账", merchandiseDate);
        String transListInfoId1 = UUID.randomUUID().toString();
        String serialNumber1 = DateUtils.getOrderOID();
        transListMapper.addTransList(transListInfoId1, receiptCard.getCardBaseInfoId(), serialNumber1, cardBaseInfoVo.getAmount(), "收款", merchandiseDate);

        return "转账成功";
    }

    /*取款*/
    @Override
    public String drawMoney(CardBaseInfoVo cardBaseInfoVo) {
        String pwd = null;
        CardBaseInfo payCard = cardBaseInfoMapper.getObjectByCardId(cardBaseInfoVo.getCardId());
        if (payCard == null) {
            return "银行卡号不存在，请重新输入";
        } else if (!payCard.getCardType().equals("借记卡")) {
            return "取款账号的类型为：" + payCard.getCardType() + "，该类型卡，不能进行取款操作！";
        }
        try {
            //加签
            pwd = Md5Util.encodeByMd5(cardBaseInfoVo.getTransPwd());
            cardBaseInfoVo.setTransPwd(pwd);
            //验签
            if (!cardBaseInfoVo.getTransPwd().equals(pwd)) {
                return "银行卡密码错误，请重新输入！";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        switch (payCard.getStat()) {
            case "挂失":
                return "取款失败，付款账号处于挂失状态";
            case "注销":
                return "取款失败，付款账号已注销";
            case "冻结":
                return "取款失败，付款账号处于冻结状态";
        }

        if (payCard.getOveage().compareTo(cardBaseInfoVo.getAmount()) == -1) {
            return "账号余额不足,不能取款！";
        }

        cardBaseInfoMapper.payment(payCard.getCardId(), cardBaseInfoVo.getAmount());

        /*添加银行卡取款交易明细*/
        String merchandiseDate = DateUtils.dataToStr1(new Date());
        String transListInfoId = UUID.randomUUID().toString();
        String serialNumber = DateUtils.getOrderOID();
        transListMapper.addTransList(transListInfoId, payCard.getCardBaseInfoId(), serialNumber, cardBaseInfoVo.getAmount(), "取款", merchandiseDate);

        return "取款成功";
    }



    /**
     * 交易明细查询
     * 1、根据TransListInfoQo查询出唯一的CardBaseInfo对象
     * 2、然后根据CardBaseInfoId查询出唯一的UserBaseInfo对象
     * 3、再根据CardBaseInfoId查询出List<TransListInfo>
     * 4、遍历transListInfos把值放入 List<TransListInfoVo>返回；
     */
    @Override
    public List<TransListInfoVo> getTransList(TransListInfoQo transListInfoQo) {
        List<TransListInfoVo> list = new ArrayList<>();
        CardBaseInfo cardBaseInfo = cardBaseInfoMapper.getObjectByCardId(transListInfoQo.getTransId());
        UserBaseInfo userBaseInfo = userBaseInfoMapper.getObjectByPrimarykey(cardBaseInfo.getUserBaseInfoId());
        List<TransListInfo> transListInfos = transListMapper.getObjectByForeignKey(cardBaseInfo.getCardBaseInfoId(), transListInfoQo.getStartTime(), transListInfoQo.getEndTime());
        for (TransListInfo transListInfo : transListInfos) {
            TransListInfoVo transListInfoVo = new TransListInfoVo();
            transListInfoVo.setSerialNumber(transListInfo.getSerialNumber());
            transListInfoVo.setTransAmount(transListInfo.getTransAmount());
            transListInfoVo.setTransTime(transListInfo.getTransTime());
            transListInfoVo.setTransType(transListInfo.getTransType());
            transListInfoVo.setTransName(userBaseInfo.getUserName());
            transListInfoVo.setTransId(cardBaseInfo.getCardId());
            transListInfoVo.setTransCardType(cardBaseInfo.getCardType());
            list.add(transListInfoVo);
        }
        return list;
    }


    @Override
    public String transferByMoney(CardBaseInfoVo cardBaseInfoVo) {
        UserBaseInfo receiptMan = null;
        CardBaseInfo receiptCard = cardBaseInfoMapper.getObjectByCardId(cardBaseInfoVo.getReceiptCardId());
        if (receiptCard == null) {
            return "收款账号不存在，请重新输入";
        } else if (!receiptCard.getCardType().equals("借记卡")) {
            return "收款账号的类型为：" + receiptCard.getCardType() + "，该类型卡，不能进行转账操作！";
        } else {
            receiptMan = userBaseInfoMapper.getObjectByPrimarykey(receiptCard.getUserBaseInfoId());
            if (!cardBaseInfoVo.getReceiptName().equals(receiptMan.getUserName()))
                return "收款账号与收款人不匹配，请再次确认";
        }
        switch (receiptCard.getStat()) {
            case "挂失":
                return "转账失败，收款账号处于挂失状态";
            case "注销":
                return "转账失败，收款账号已注销";
            case "冻结":
                return "转账失败，收款账号处于冻结状态";
        }
        cardBaseInfoMapper.receipt(receiptCard.getCardId(), cardBaseInfoVo.getAmount());

        /*添加现金转账交易明细*/
        String merchandiseDate = DateUtils.dataToStr1(new Date());
        String transListInfoId = UUID.randomUUID().toString();
        String serialNumber = DateUtils.getOrderOID();
        transListMapper.addTransList(transListInfoId, receiptCard.getCardBaseInfoId(), serialNumber, cardBaseInfoVo.getAmount(), "收款", merchandiseDate);
        return "现金转账成功";
    }

    @Override
    public String exportXls(TransListInfoQo transListInfoQo, HttpServletResponse response, HttpServletRequest request) throws IOException {
        //第一步：查询查询的数据
        List<TransListInfoVo> list = this.getTransList(transListInfoQo);
        //第二步：使用POI将数据写到Excel文件中
        //在内存中创建一个Excel文件
        try (HSSFWorkbook workbook = new HSSFWorkbook()) {
            //创建一个标签页
            HSSFSheet sheet = workbook.createSheet("交易明细");

            //创建标题行
            HSSFRow headRow = sheet.createRow(0);
            headRow.createCell(0).setCellValue("交易流水号");
            headRow.createCell(1).setCellValue("持卡姓名");
            headRow.createCell(2).setCellValue("银行卡号");
            headRow.createCell(3).setCellValue("交易类型");
            headRow.createCell(4).setCellValue("交易银行卡类型");
            headRow.createCell(5).setCellValue("交易金额");
            headRow.createCell(6).setCellValue("交易时间");
            for (TransListInfoVo region : list) {
                HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
                dataRow.createCell(0).setCellValue(region.getSerialNumber());
                dataRow.createCell(1).setCellValue(region.getTransName());
                dataRow.createCell(2).setCellValue(region.getTransId());
                dataRow.createCell(3).setCellValue(region.getTransType());
                dataRow.createCell(4).setCellValue(region.getTransCardType());
                dataRow.createCell(5).setCellValue(region.getTransAmount().toString());
                dataRow.createCell(6).setCellValue(region.getTransTime());
            }

            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/x-download");
            String filedisplay = "未匹配的产品清单.xls";
            response.setHeader("Content-Disposition", "attachment;filename="+ filedisplay);

            try (FileOutputStream fileOutputStream = new FileOutputStream(request.getContextPath()+transListInfoQo.getTransId()+".xls")) {
                workbook.write(fileOutputStream);
            }
        }
        return "账单导出成功";
    }

}
