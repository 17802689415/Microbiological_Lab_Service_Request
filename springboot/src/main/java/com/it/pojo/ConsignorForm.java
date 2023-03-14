package com.it.pojo;

import java.io.Serializable;

public class ConsignorForm implements Serializable {
    public int id;
    private String consignorId;
    private String phoneNum;
    private String workCell;
    private String department;
    private String applyDate;
    private String sendDate;
    private boolean urgent;

    @Override
    public String toString() {
        return "ConsignorInfo{" +
                "id=" + id +
                ", consignorId='" + consignorId + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", workCell='" + workCell + '\'' +
                ", department='" + department + '\'' +
                ", applyDate='" + applyDate + '\'' +
                ", sendDate='" + sendDate + '\'' +
                ", urgent=" + urgent +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConsignorId() {
        return consignorId;
    }

    public void setConsignorId(String consignorId) {
        this.consignorId = consignorId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getWorkCell() {
        return workCell;
    }

    public void setWorkCell(String workCell) {
        this.workCell = workCell;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }
}
