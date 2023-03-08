package com.it.pojo;

public class User {
    private int id;
    private String username;
    private String jobId;
    private String department;
    private String jobTitle;
    private String responsibility;
    private String backupFor;
    private String premission;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public String getBackupFor() {
        return backupFor;
    }

    public void setBackupFor(String backupFor) {
        this.backupFor = backupFor;
    }

    public String getPremission() {
        return premission;
    }

    public void setPremission(String premission) {
        this.premission = premission;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
