package com.example.cloud.common.io;

import java.io.Serializable;

/***
 *
 */
public class ExpressBean implements Serializable {


    private String empNo;

    private String empName;

    private int age;

    private String empJob;

    private String company;

    public ExpressBean( String empNo,  String empName,  int age,  String empJob,  String company) {
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

    public int getAge() {
        return this.age;
    }

    public void setAge(final int age) {
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

    @Override
    public String toString() {
        return "ExpressBean{" +
                "empNo='" + empNo + '\'' +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", empJob='" + empJob + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
