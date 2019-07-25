package com.example.cloud.server.mapper.employee;


import com.example.cloud.common.io.Employee;
import com.example.cloud.common.io.ExpressBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExpressDaoMapper {

    List<ExpressBean> queryExpress();

    List<Employee> queryEmployee();

    Integer insertExpress(@Param("expressBeanList") List<ExpressBean> expressBeanList);
}
