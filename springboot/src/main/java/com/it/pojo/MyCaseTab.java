package com.it.pojo;

public class MyCaseTab {
    private int id;
    private String applyNum;
    private String testType;
    private String consignor;
    private String sendDate;
    private String status;

    @Override
    public String toString() {
        return "MyCaseTab{" +
                "id=" + id +
                ", applyNum='" + applyNum + '\'' +
                ", testType='" + testType + '\'' +
                ", consignor='" + consignor + '\'' +
                ", sendDate='" + sendDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(String applyNum) {
        this.applyNum = applyNum;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getConsignor() {
        return consignor;
    }

    public void setConsignor(String consignor) {
        this.consignor = consignor;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
