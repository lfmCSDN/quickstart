package com.ty.tybs.web.service.impl;


import com.ty.tybs.web.entity.po.CardBaseInfo;
import com.ty.tybs.web.entity.po.UserBaseInfo;
import com.ty.tybs.web.entity.po.UserOperInfo;
import com.ty.tybs.web.entity.qo.UserAndCardQo;
import com.ty.tybs.web.entity.qo.UserBaseInfoQo;
import com.ty.tybs.web.entity.vo.CardBaseInfoVo;
import com.ty.tybs.web.entity.vo.RsaPwdInfoVo;
import com.ty.tybs.web.entity.vo.UserAndCardVo;
import com.ty.tybs.web.entity.vo.UserBaseInfoVo;
import com.ty.tybs.web.mapper.CardBaseInfoMapper;
import com.ty.tybs.web.mapper.OperatorMapper;
import com.ty.tybs.web.mapper.RsaPwdInfoMapper;
import com.ty.tybs.web.mapper.UserBaseInfoMapper;
import com.ty.tybs.web.service.OperatorService;
import com.ty.tybs.web.util.Md5Util;
import com.ty.tybs.web.util.RSAUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * create by Lfm
 * on 2018-03-19 22:39
 */
@Service
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorMapper operatorMapper;
    @Autowired
    private CardBaseInfoMapper cardBaseInfoMapper;
    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper;
    @Autowired
    private RsaPwdInfoMapper rsaPwdInfoMapper;

    /*操作员登录*/
    @Override
    public UserOperInfo login(String username, String password) {
        String pwd = null;
        try {
            pwd = Md5Util.encodeByMd5(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return operatorMapper.getOperator(username, pwd);

    }

    /**
     * 开通账户
     *
     * @param userAndCardVo
     */
    @Override
    public String addUser(UserAndCardVo userAndCardVo) {

        String pwd = null;
        UserBaseInfo userBaseInfo = userBaseInfoMapper.getObjectByCardId(userAndCardVo.getUserCardId());
        try {
            /*交易密码进行MD5加密*/
            pwd = Md5Util.encodeByMd5(userAndCardVo.getTransPwd());
            userAndCardVo.setTransPwd(pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (userBaseInfo == null) {
            if (cardBaseInfoMapper.getObjectByCardId(userAndCardVo.getCardId()) != null) {
                return "该银行卡号已存在，开通账户失败！";
            } else {
                //Uuid随机设生成一个随机数,作为useBaseInfo和CardBaseInfo的主键
                userAndCardVo.setCardBaseInfoId(UUID.randomUUID().toString());
                userAndCardVo.setUserBaseInfoId(UUID.randomUUID().toString());
                userBaseInfoMapper.addUserBaseInfo(userAndCardVo);
                cardBaseInfoMapper.addCardBaseInfo(userAndCardVo);
            }
        } else {
            if (userAndCardVo.getUserName().equals(userBaseInfo.getUserName())) {
                CardBaseInfo cardBaseInfo = cardBaseInfoMapper.getObjectByForeignKey(userBaseInfo.getUserBaseInfoId(), userAndCardVo.getCardType());
                if (cardBaseInfo == null) {
                    if (cardBaseInfoMapper.getObjectByCardId(userAndCardVo.getCardId()) != null) {
                        return "该银行卡号已存在，开通账户失败！";
                    } else {
                        userAndCardVo.setCardBaseInfoId(UUID.randomUUID().toString());
                        userAndCardVo.setUserBaseInfoId(userBaseInfo.getUserBaseInfoId());
                        cardBaseInfoMapper.addCardBaseInfo(userAndCardVo);
                    }
                } else {
                    return "该用户已在该行开此类型银行卡，不允许再次开通该类型账户！";
                }
            } else {
                return "用户姓名与该身份证不符，请重新输入！";
            }
        }
        return "账户已开通！";
    }

    /**
     * 查询账户
     *
     * @param userAndCardQo
     * @return
     */
    @Override
    public List<UserAndCardVo> getUser(UserAndCardQo userAndCardQo) {
        return userBaseInfoMapper.getUserByIdCard(userAndCardQo);
    }

    /**
     * 注销账户
     * 改变账户的状态，注销状态，改卡不能进项任何操作
     *
     * @param userAndCardVo
     */
    @Override
    public String deleteUser(UserAndCardVo userAndCardVo) {
        List<CardBaseInfo> cardBaseInfos = cardBaseInfoMapper.getObjectByKey(userAndCardVo.getUserBaseInfoId());
        for (CardBaseInfo cardBaseInfo : cardBaseInfos) {
            if (userAndCardVo.getCardId().equals(cardBaseInfo.getCardId())) {
                cardBaseInfoMapper.delCardById(cardBaseInfo.getCardBaseInfoId());
                break;
            }
        }
        return "该卡已注销，将不能进行任何交易操作！";
    }

    /**
     * 挂失账户
     *
     * @param userAndCardVo
     * @return
     */
    @Override
    public String lostUser(UserAndCardVo userAndCardVo) {
        List<CardBaseInfo> cardBaseInfos = cardBaseInfoMapper.getObjectByKey(userAndCardVo.getUserBaseInfoId());
        for (CardBaseInfo cardBaseInfo : cardBaseInfos) {
            if (userAndCardVo.getCardId().equals(cardBaseInfo.getCardId())) {
                switch (cardBaseInfo.getStat()) {
                    case "挂失":
                        return "该卡当前已挂失，不能进行挂失操作！";
                    case "注销":
                        return "该卡当前已注销，不能进行挂失操作！";
                    case "冻结":
                        return "该卡当前已冻结，不能再次进行挂失操作！";
                }
                cardBaseInfoMapper.lostUser(cardBaseInfo.getCardBaseInfoId());
                break;
            }
        }
        return "挂失成功，该卡将不能进行任何交易操作！";
    }

    @Override
    public String freezeUser(UserAndCardVo userAndCardVo) {
        List<CardBaseInfo> cardBaseInfos = cardBaseInfoMapper.getObjectByKey(userAndCardVo.getUserBaseInfoId());
        for (CardBaseInfo cardBaseInfo : cardBaseInfos) {
            if (userAndCardVo.getCardId().equals(cardBaseInfo.getCardId())) {
                switch (cardBaseInfo.getStat()) {
                    case "挂失":
                        return "该卡当前已挂失，不能进行冻结操作！";
                    case "注销":
                        return "该卡当前已注销，不能进行冻结操作！";
                    case "冻结":
                        return "该卡当前已冻结，不能再次进行冻结操作！";
                }
                cardBaseInfoMapper.freezeUser(cardBaseInfo.getCardBaseInfoId());
                break;
            }
        }
        return "冻结成功，该卡将不能进行任何交易操作！";
    }

    @Override
    public String upLostUser(UserAndCardVo userAndCardVo) {
        List<CardBaseInfo> cardBaseInfos = cardBaseInfoMapper.getObjectByKey(userAndCardVo.getUserBaseInfoId());
        for (CardBaseInfo cardBaseInfo : cardBaseInfos) {
            if (userAndCardVo.getCardId().equals(cardBaseInfo.getCardId())) {
                switch (cardBaseInfo.getStat()) {
                    case "正常":
                        return "该卡当前处于正常状态，不需要进行解挂操作";
                    case "冻结":
                        return "该卡当前已冻结，不能进行解挂操作！";
                    case "注销":
                        return "该卡当前已注销，不能进行解挂操作！";
                }
                cardBaseInfoMapper.upLostUser(cardBaseInfo.getCardBaseInfoId());
                break;
            }
        }
        return "解挂成功，该卡恢复正常！";
    }

    @Override
    public String upFreezeUser(UserAndCardVo userAndCardVo) {
        List<CardBaseInfo> cardBaseInfos = cardBaseInfoMapper.getObjectByKey(userAndCardVo.getUserBaseInfoId());
        for (CardBaseInfo cardBaseInfo : cardBaseInfos) {
            if (userAndCardVo.getCardId().equals(cardBaseInfo.getCardId())) {
                switch (cardBaseInfo.getStat()) {
                    case "正常":
                        return "该卡当前处于正常状态，不需要进行解冻操作";
                    case "挂失":
                        return "该卡当前已挂失，不能进行解冻操作！";
                    case "注销":
                        return "该卡当前已注销，不能进行解冻操作！";
                }
                cardBaseInfoMapper.upFreezeUser(cardBaseInfo.getCardBaseInfoId());
                break;
            }
        }
        return "解冻成功，该卡恢复正常！";
    }

    @Override
    public String modifyPwd(CardBaseInfoVo cardBaseInfoVo) {
        String pwd = null;
        String newPwd1 = null;
        String newPwd2 = null;
        CardBaseInfo cardBaseInfo = cardBaseInfoMapper.getObjectByCardId(cardBaseInfoVo.getCardId());
        try {
            pwd = Md5Util.encodeByMd5(cardBaseInfoVo.getTransPwd());
            newPwd1 = Md5Util.encodeByMd5(cardBaseInfoVo.getTransPwd1());
            newPwd2 = Md5Util.encodeByMd5(cardBaseInfoVo.getTransPwd2());
            cardBaseInfoVo.setTransPwd1(newPwd1);
            cardBaseInfoVo.setTransPwd2(newPwd2);
            cardBaseInfoVo.setTransPwd(pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (cardBaseInfo.getStat().equals("正常")) {
            if (!cardBaseInfoVo.getTransPwd().equals(cardBaseInfo.getTransPwd())) {
                return "银行卡密码错误";
            } else {
                if (!cardBaseInfoVo.getTransPwd2().equals(cardBaseInfoVo.getTransPwd1())) {
                    return "两次密码输入不相符,请重新输入!";
                } else {
                    cardBaseInfoMapper.modifyPwd(cardBaseInfoVo.getTransPwd1(), cardBaseInfoVo.getCardId());
                }
            }
        } else {
            return "该卡当前为" + cardBaseInfo.getStat() + "状态,不能进行银行卡密码修改！";
        }
        return "密码修改成功";
    }

    @Override
    public String resetPwd(CardBaseInfoVo cardBaseInfoVo) {
        String newPwd1 = null;
        CardBaseInfo cardBaseInfo = cardBaseInfoMapper.getObjectByCardId(cardBaseInfoVo.getCardId());
        if (cardBaseInfo.getStat().equals("正常")) {
            if (!cardBaseInfoVo.getTransPwd2().equals(cardBaseInfoVo.getTransPwd1())) {
                return "两次密码输入不相符,请重新输入密码!";
            } else {
                try {
                    newPwd1 = Md5Util.encodeByMd5(cardBaseInfoVo.getTransPwd1());
                    cardBaseInfoVo.setTransPwd1(newPwd1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                cardBaseInfoMapper.resetPwd(cardBaseInfoVo.getTransPwd1(), cardBaseInfoVo.getCardId());
            }
        } else {
            return "该账户：" + cardBaseInfoVo.getCardId() + "当前为" + cardBaseInfo.getStat() + "状态,不能进行银行卡密码重置！";
        }
        return "账户：" + cardBaseInfoVo.getCardId() + ",密码已经重置成功！";
    }

    @Override
    public String modifyUser(UserBaseInfoQo userBaseInfoQo) {
        UserBaseInfo userBaseInfo = userBaseInfoMapper.getObjectByPrimarykey(userBaseInfoQo.getUserBaseInfoId());
        if (!userBaseInfoQo.getUserName().equals(userBaseInfo.getUserName())) {
            return "客户的姓名" + userBaseInfo.getUserName() + "，不能被修改！";
        } else if (!userBaseInfoQo.getUserCardId().equals(userBaseInfo.getUserCardId())) {
            return "客户的身份证号：" + userBaseInfo.getUserCardId() + "，不能被修改！";
        } else {
            userBaseInfoMapper.modifyTelUser(userBaseInfoQo);
        }
        return "客户:" + userBaseInfoQo.getUserName() + "，个人信息修改成功！";
    }

    @Override
    public List<UserBaseInfoVo> getAcct(UserBaseInfoQo userBaseInfoQo) {
        return userBaseInfoMapper.getAcct(userBaseInfoQo);
    }
}
