package com.ty.tybs.web.entity.qo;

import com.ty.tybs.web.entity.po.UserBaseInfo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * User:honc.z
 * Date:2018-03-30
 */
public class CardBaseInfoQo {
    //    主键
    private String cardBaseInfoId;
    //    银行卡ID
    private String cardId;
    //    交易密码
    private String transPwd;
    //   交易密码错误次数
    private Integer transPwdNum;
    //   卡状态
    private String stat;
    //    账户余额
    private BigDecimal oveage;
    //    开户日期
    private String openDate;
    //    银行卡类型
    private String cardType;
    //  第一次输入交易密码
    private String transPwd1;
    //  第二次输入交易密码
    private String transPwd2;
    //账户姓名
    private String acctName;
    // 交易数目
    private BigDecimal amount;
    //支付银行卡号
    private String payCardId;
    // 收款人姓名
    private String receiptName;
    // 收款人银行卡号
    private String receiptCardId;

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

    public Integer getTransPwdNum() {
        return transPwdNum;
    }

    public void setTransPwdNum(Integer transPwdNum) {
        this.transPwdNum = transPwdNum;
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

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getTransPwd1() {
        return transPwd1;
    }

    public void setTransPwd1(String transPwd1) {
        this.transPwd1 = transPwd1;
    }

    public String getTransPwd2() {
        return transPwd2;
    }

    public void setTransPwd2(String transPwd2) {
        this.transPwd2 = transPwd2;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPayCardId() {
        return payCardId;
    }

    public void setPayCardId(String payCardId) {
        this.payCardId = payCardId;
    }

    public String getReceiptName() {
        return receiptName;
    }

    public void setReceiptName(String receiptName) {
        this.receiptName = receiptName;
    }

    public String getReceiptCardId() {
        return receiptCardId;
    }

    public void setReceiptCardId(String receiptCardId) {
        this.receiptCardId = receiptCardId;
    }
}
