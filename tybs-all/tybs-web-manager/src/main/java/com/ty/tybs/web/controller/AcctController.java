package com.ty.tybs.web.controller;

import com.ty.tybs.web.entity.qo.TransListInfoQo;
import com.ty.tybs.web.entity.vo.CardBaseInfoVo;
import com.ty.tybs.web.entity.vo.TableVo;
import com.ty.tybs.web.entity.vo.TransListInfoVo;
import com.ty.tybs.web.service.AcctService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * create by Lfm
 * on 2018-03-24 14:32
 * 交易管理
 */
@Controller
@RequestMapping("/acct")
public class AcctController {

    @Autowired
    private AcctService acctService;


    /*存款*/
    @RequestMapping("/toBankSaving")
    public String toBankSaving() {
        return "bankSaving";
    }

    /*取款*/
    @RequestMapping("/toDrawMoney")
    public String toDrawMoney() {
        return "drawMoney";
    }

    /*转账*/
    @RequestMapping("/toTransfer")
    public String toTransfer() {
        return "transfer";
    }

    /*转账*/
    @RequestMapping("/toTransferByMoney")
    public String toTransferByMoney() {
        return "transferByMoney";
    }

    /*交易明细*/
    @RequestMapping("/toTransList")
    public String toTransList() {
        return "transList";
    }


    @RequestMapping("/bankSaving")
    @ResponseBody
    public String bankSaving(CardBaseInfoVo cardBaseInfoVo) {
        return acctService.bankSaving(cardBaseInfoVo);
    }


    @RequestMapping("/drawMoney")
    @ResponseBody
    public String drawMoney(CardBaseInfoVo cardBaseInfoVo) {
        return acctService.drawMoney(cardBaseInfoVo);
    }


    @RequestMapping("/transfer")
    @ResponseBody
    public String transfer(CardBaseInfoVo cardBaseInfoVo) {
        return acctService.transfer(cardBaseInfoVo);
    }

    @RequestMapping("/transferByMoney")
    @ResponseBody
    public String transferByMoney(CardBaseInfoVo cardBaseInfoVo) {
        return acctService.transferByMoney(cardBaseInfoVo);
    }


    @RequestMapping("/getTransList")
    @ResponseBody
    public TableVo<TransListInfoVo> getTransList(TransListInfoQo transListInfoQo, Model model) {
        List<TransListInfoVo> list = acctService.getTransList(transListInfoQo);
        TableVo<TransListInfoVo> tableVo = new TableVo<>();
        tableVo.setCode(0);
        tableVo.setMsg("success");
        tableVo.setCount(list.size());
        tableVo.setData(list);
        return tableVo;
    }

    /*批量导出*/
    @RequestMapping("/exportXls")
    @ResponseBody
    public String exportXls(TransListInfoQo transListInfoQo, HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest) throws IOException {
        return acctService.exportXls(transListInfoQo, httpServletResponse, httpServletRequest);
    }
}
