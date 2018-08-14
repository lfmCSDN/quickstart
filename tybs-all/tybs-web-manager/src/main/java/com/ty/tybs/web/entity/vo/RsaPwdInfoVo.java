package com.ty.tybs.web.entity.vo;

/**
 * create by Lfm
 * on 2018-06-13 15:55
 */
public class RsaPwdInfoVo {
    private String rsaPwdInfoId;
    private  String cardBaseInfoId;
    private  String publicKey;
    private String privateKey;

    public String getRsaPwdInfoId() {
        return rsaPwdInfoId;
    }

    public void setRsaPwdInfoId(String rsaPwdInfoId) {
        this.rsaPwdInfoId = rsaPwdInfoId;
    }

    public String getCardBaseInfoId() {
        return cardBaseInfoId;
    }

    public void setCardBaseInfoId(String cardBaseInfoId) {
        this.cardBaseInfoId = cardBaseInfoId;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
}
