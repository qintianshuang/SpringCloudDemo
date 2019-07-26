package com.example.cloud.service.service;

import com.example.cloud.common.io.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> queryEmployeeByName(String name);

    void insertEmployeeList(List<Employee> employeeList);

    Employee queryEmployeeByEmpNo(String empNo);

    Employee queryEmployee(Employee employee);

    void creatEmployeeInfo(Employee employee);
}