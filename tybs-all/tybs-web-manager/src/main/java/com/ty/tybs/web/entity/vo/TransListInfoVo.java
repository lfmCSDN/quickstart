package com.ty.tybs.web.entity.vo;

import java.math.BigDecimal;

/**
 * User:LFM
 * Date:2018-03-30
 */
public class TransListInfoVo {
    //    主键
    private String transListInfoId;

    private String cardBaseInfoId;

    private String userBaseInfoId;
    //    交易流水号
    private String serialNumber;

    private String transName;

    private String transId;
    //    交易类型
    private String transType;
    //    交易金额
    private BigDecimal transAmount;
    //    交易时间
    private String transTime;

    public String getTransCardType() {
        return transCardType;
    }

    public void setTransCardType(String transCardType) {
        this.transCardType = transCardType;
    }

    private String transCardType;



    public String getTransListInfoId() {
        return transListInfoId;
    }

    public void setTransListInfoId(String transListInfoId) {
        this.transListInfoId = transListInfoId;
    }

    public String getCardBaseInfoId() {
        return cardBaseInfoId;
    }

    public void setCardBaseInfoId(String cardBaseInfoId) {
        this.cardBaseInfoId = cardBaseInfoId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }
    public String getUserBaseInfoId() {
        return userBaseInfoId;
    }

    public void setUserBaseInfoId(String userBaseInfoId) {
        this.userBaseInfoId = userBaseInfoId;
    }
}
