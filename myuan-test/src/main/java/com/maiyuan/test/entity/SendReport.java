package com.maiyuan.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Administrator on 2017/7/19.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendReport {
    @JsonProperty(value = "taskID")
    private String taskID;
    @JsonProperty(value = "mobile")
    private String mobile;
    @JsonProperty(value = "status")
    private String status;
    @JsonProperty(value = "reportTime")
    private String reportTime;
    @JsonProperty(value = "reportCode")
    private String reportCode;
    @JsonProperty(value = "outTradeNo")
    private String outTradeNo;

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportCode() {
        return reportCode;
    }

    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }
}
