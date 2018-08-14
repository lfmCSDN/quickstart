package com.ty.tybs.web.entity.po;

import java.math.BigDecimal;
import java.util.Date;

/**
 * User:honc.z
 * Date:2018-03-30
 */
public class CardBaseInfo {
    //    主键
    private String cardBaseInfoId;

    private String userBaseInfoId;
    //    银行卡ID
    private String cardId;
    //    交易密码
    private String transPwd;
    //   卡状态
    private String stat;
    //    账户余额
    private BigDecimal oveage;
    //    开户日期
    private String openDate;
    //    银行卡类型
    private String cardType;

    public String getCardBaseInfoId() {
        return cardBaseInfoId;
    }

    public void setCardBaseInfoId(String cardBaseInfoId) {
        this.cardBaseInfoId = cardBaseInfoId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getTransPwd() {
        return transPwd;
    }

    public void setTransPwd(String transPwd) {
        this.transPwd = transPwd;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public BigDecimal getOveage() {
        return oveage;
    }

    public void setOveage(BigDecimal oveage) {
        this.oveage = oveage;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openData) {
        this.openDate = openDate;
    }

    public String getCardType() { return cardType; }

    public void setCardType(String cardType) { this.cardType = cardType; }

    public String getUserBaseInfoId() {
        return userBaseInfoId;
    }

    public void setUserBaseInfoId(String userBaseInfoId) {
        this.userBaseInfoId = userBaseInfoId;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }
}
