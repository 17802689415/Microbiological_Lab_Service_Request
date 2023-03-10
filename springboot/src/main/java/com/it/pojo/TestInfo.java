package com.it.pojo;

import java.io.Serializable;

public class TestInfo implements Serializable {
    private int id;
    private String applyNum;
    private String sampleName;
    private String model;
    private String lotNo;
    private double quantity;
    private String testItem;
    private String wiNo;
    private double limitValue;


    @Override
    public String toString() {
        return "TestInfo{" +
                "id=" + id +
                ", applyNum='" + applyNum + '\'' +
                ", sampleName='" + sampleName + '\'' +
                ", model='" + model + '\'' +
                ", lotNo='" + lotNo + '\'' +
                ", quantity=" + quantity +
                ", testItem='" + testItem + '\'' +
                ", wiNo='" + wiNo + '\'' +
                ", limitValue=" + limitValue +
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

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getTestItem() {
        return testItem;
    }

    public void setTestItem(String testItem) {
        this.testItem = testItem;
    }

    public String getWiNo() {
        return wiNo;
    }

    public void setWiNo(String wiNo) {
        this.wiNo = wiNo;
    }

    public double getLimitValue() {
        return limitValue;
    }

    public void setLimitValue(double limitValue) {
        this.limitValue = limitValue;
    }
}
