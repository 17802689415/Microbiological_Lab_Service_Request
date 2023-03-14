package com.it.pojo;

import java.io.Serializable;

public class SampleForm implements Serializable {
    public int id;
    private String applyNum;
    private String testPurpose;
    private String sampleName;
    private String sampleQuantity;
    private String batchNo;
    private String disposal;
    private String storageCondition;

    @Override
    public String toString() {
        return "SampleForm{" +
                "id=" + id +
                ", applyNum='" + applyNum + '\'' +
                ", testPurpose='" + testPurpose + '\'' +
                ", sampleName='" + sampleName + '\'' +
                ", sampleQuantity='" + sampleQuantity + '\'' +
                ", batchNo='" + batchNo + '\'' +
                ", disposal='" + disposal + '\'' +
                ", storageCondition='" + storageCondition + '\'' +
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

    public String getTestPurpose() {
        return testPurpose;
    }

    public void setTestPurpose(String testPurpose) {
        this.testPurpose = testPurpose;
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public String getSampleQuantity() {
        return sampleQuantity;
    }

    public void setSampleQuantity(String sampleQuantity) {
        this.sampleQuantity = sampleQuantity;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getDisposal() {
        return disposal;
    }

    public void setDisposal(String disposal) {
        this.disposal = disposal;
    }

    public String getStorageCondition() {
        return storageCondition;
    }

    public void setStorageCondition(String storageCondition) {
        this.storageCondition = storageCondition;
    }
}
