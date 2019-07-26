package com.example.cloud.web.bean.employee;

import java.math.BigDecimal;

/***
 *
 */
public class Employee {
    //人员编号
    private String empNo;

    //人员名称
    private String empName;

    //年龄
    private int age;

    //身份证号码
    private String identityCard;

    //户籍所下地
    private String familyAddress;

    //居住地址
    private String liveAddress;

    //联系电话
    private String phone;

    //邮箱
    private String email;

    public Employee() {
        super();
    }

    public Employee(String empNo, String empName, int age, String identityCard, String liveAddress, String familyAddress, String phone, String email) {
        this.empNo = empNo;
        this.empName = empName;
        this.age = age;
        this.identityCard = identityCard;
        this.liveAddress = liveAddress;
        this.familyAddress = familyAddress;
        this.phone = phone;
        this.email = email;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getLiveAddress() {
        return liveAddress;
    }

    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress;
    }

    public String getFamilyAddress() {
        return familyAddress;
    }

    public void setFamilyAddress(String familyAddress) {
        this.familyAddress = familyAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo='" + empNo + '\'' +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", identityCard='" + identityCard + '\'' +
                ", liveAddress='" + liveAddress + '\'' +
                ", familyAddress='" + familyAddress + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
