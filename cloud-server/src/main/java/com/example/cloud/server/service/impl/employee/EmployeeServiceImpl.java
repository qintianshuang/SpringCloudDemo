package com.example.cloud.server.service.impl.employee;

import com.example.cloud.common.config.Logger;
import com.example.cloud.common.io.Employee;
import com.example.cloud.common.util.JsonUtil;
import com.example.cloud.server.mapper.employee.EmployeeDaoMapper;
import com.example.cloud.server.po.employee.EmployeePO;
import com.example.cloud.service.service.IEmployeeService;
import com.example.cloud.service.util.RandomUtils;
import com.example.cloud.service.util.RedisUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "empService")
public class EmployeeServiceImpl implements IEmployeeService {

    private final static Logger log = Logger.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private EmployeeDaoMapper employeeDaoMapper;

    /***
     *
     * @return
     */
    @Override
    public List<Employee> queryEmployeeByName(String empName) {
        List<Employee> employeeList = new ArrayList<>();
        if (StringUtils.isEmpty(empName)){
            return employeeList;
        }
        List<EmployeePO> employeePOList = employeeDaoMapper.queryEmployeeByName(empName);
        if (!CollectionUtils.isEmpty(employeePOList)) {
            for (EmployeePO employeePO : employeePOList) {
                Employee employee = new Employee();
                BeanUtils.copyProperties(employeePO, employee);
                employeeList.add(employee);
                String key = "emp" + employee.getEmpNo() + "info";
                Object value = redisUtil.getValue(key, Employee.class);
                log.debug("value||" + value);
            }
        }
        log.debug("employeeList" + employeeList);
        return employeeList;
    }

    /***
     *
     * @param employeeList
     */
    @Override
    public void insertEmployeeList(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            employee.setEmpNo(RandomUtils.randomID());
        }
        //查出数据库中已经存在的信息
        List<EmployeePO> expressBeanList = employeeDaoMapper.queryEmployeeList();
        Map<String, Employee> map = new HashMap<>();
        //将查出来的数据放入map中
        for (EmployeePO employeePO : expressBeanList) {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeePO, employee);
            map.put(employee.getEmpNo(), employee);
        }
        List<Employee> employeeArrayList = new ArrayList<>();
       //遍历要插入的数据
        if (!CollectionUtils.isEmpty(employeeList)) {
            for (int i = 0; i < employeeList.size(); i++) {
                //对比数据库的数据，过滤点重复的数据
                if (StringUtils.isEmpty(map.get(employeeList.get(i).getEmpNo()))) {
                    //将不存在的新数据保存到新集合
                    employeeArrayList.add(employeeList.get(i));
                }
            }
        }
        log.debug("expressBeanArrayList||" + employeeArrayList);
        if (!CollectionUtils.isEmpty(employeeArrayList)) {
            //如果新数据不为空，插入到数据库
            Integer index = employeeDaoMapper.insertEmployeeList(employeeArrayList);
            for (Employee employee : employeeArrayList) {
                String key = "emp" + employee.getEmpNo() + "info";
                log.debug("JsonUtil.getObjectToJson(expressBean)||" + JsonUtil.getObjectToJson(employee));
                redisUtil.setValue(key, JsonUtil.getObjectToJson(employee));
            }
        }
    }

    @Override
    public Employee queryEmployeeByEmpNo(String name) {
        return null;
    }

    @Override
    public Employee queryEmployee(Employee employee) {
        return null;
    }
}
