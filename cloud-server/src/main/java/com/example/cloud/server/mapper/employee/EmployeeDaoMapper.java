package com.example.cloud.server.mapper.employee;


import com.example.cloud.common.io.Employee;
import com.example.cloud.server.po.employee.EmployeePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeeDaoMapper {

    List<EmployeePO> queryEmployeeList();

    List<EmployeePO> queryEmployeeByName(@Param("empName") String empName);

    Integer insertEmployeeList(@Param("employeeList") List<Employee> employeeList);

    Integer creatEmployee(EmployeePO employeePO);
}
