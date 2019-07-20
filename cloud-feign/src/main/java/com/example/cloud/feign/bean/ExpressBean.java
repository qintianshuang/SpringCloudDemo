package com.example.cloud.feign.bean;

public class ExpressBean {

    private String empNo;

    private String empName;

    private String age;

    private String empJob;

    private String company;

    public ExpressBean(final String empNo, final String empName, final String age, final String empJob, final String company) {
        this.empNo = empNo;
        this.empName = empName;
        this.age = age;
        this.empJob = empJob;
        this.company = company;
    }

    public String getEmpNo() {
        return this.empNo;
    }

    public void setEmpNo(final String empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return this.empName;
    }

    public void setEmpName(final String empName) {
        this.empName = empName;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(final String age) {
        this.age = age;
    }

    public String getEmpJob() {
        return this.empJob;
    }

    public void setEmpJob(final String empJob) {
        this.empJob = empJob;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(final String company) {
        this.company = company;
    }
}
