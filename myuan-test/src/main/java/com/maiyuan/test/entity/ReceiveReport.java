package com.maiyuan.test.entity;

/**
 * Created by Administrator on 2017/7/19.
 */
public class ReceiveReport {
    private String action;
    private String v;
    private String account;
    private String mobile;
    private String packagez;
    private String sign;
    private String outTradeNo;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPackagez() {
        return packagez;
    }

    public void setPackagez(String packagez) {
        this.packagez = packagez;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    @Override
    public String toString() {
        return "ReceiveReport{" +
                "action='" + action + '\'' +
                ", v='" + v + '\'' +
                ", account='" + account + '\'' +
                ", mobile='" + mobile + '\'' +
                ", packagez='" + packagez + '\'' +
                ", sign='" + sign + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                '}';
    }
}
