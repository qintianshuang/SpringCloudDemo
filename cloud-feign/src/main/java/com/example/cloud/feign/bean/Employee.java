package com.example.cloud.feign.bean;

import java.math.BigDecimal;

/***
 *
 */
public class Employee {

    private String employeeId;
    private String fristName;
    private int lastName;
    private String email;
    private String phoneNumber;
    private String jobId;
    private BigDecimal salary;
    private BigDecimal commissionPct;
    private String managerId;
    private String departmentId;

    public Employee(final String employeeId, final String fristName, final int lastName, final String email, final String phoneNumber, final String jobId, final BigDecimal salary, final BigDecimal commissionPct, final String managerId, final String departmentId) {
        this.employeeId = employeeId;
        this.fristName = fristName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.jobId = jobId;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.managerId = managerId;
        this.departmentId = departmentId;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(final String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFristName() {
        return this.fristName;
    }

    public void setFristName(final String fristName) {
        this.fristName = fristName;
    }

    public int getLastName() {
        return this.lastName;
    }

    public void setLastName(final int lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getJobId() {
        return this.jobId;
    }

    public void setJobId(final String jobId) {
        this.jobId = jobId;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(final BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getCommissionPct() {
        return this.commissionPct;
    }

    public void setCommissionPct(final BigDecimal commissionPct) {
        this.commissionPct = commissionPct;
    }

    public String getManagerId() {
        return this.managerId;
    }

    public void setManagerId(final String managerId) {
        this.managerId = managerId;
    }

    public String getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(final String departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "ExpressBean{" +
                "employeeId='" + employeeId + '\'' +
                ", fristName='" + fristName + '\'' +
                ", lastName=" + lastName +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", jobId='" + jobId + '\'' +
                ", salary=" + salary +
                ", commissionPct=" + commissionPct +
                ", managerId='" + managerId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }
}
