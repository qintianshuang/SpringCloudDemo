package com.example.cloud.app.controller;

import com.example.cloud.common.io.Employee;
import com.example.cloud.common.io.ExpressBean;
import com.example.cloud.service.config.LogUtils;
import com.example.cloud.service.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 *
 */
@RestController
public class EmployeeController {

//    private final static Logger log = Logger.getLogger(EmployeeController.class);


    @Autowired
    @Qualifier("empService")
    private IEmployeeService empService;

    @GetMapping(value = "/index")
    public Object home(@RequestParam(value = "name") String name, @RequestParam(value = "classNo") String classNo) {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    @GetMapping(value = "/list")
    public List<Employee> queryEmployee() {
        System.out.println("我被调用了");
        List<Employee> employees = empService.queryEmployee();
        System.out.println(employees);
        return employees;
    }

    @GetMapping(value = "/query")
    public List<ExpressBean> query() {
        List<ExpressBean> expressBeanList = empService.queryExpress();
        return expressBeanList;
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public String addHelloPort(@RequestBody List<ExpressBean> expressBeans) {


        //springboot   获取上下文
//        ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
//        String[] str= applicationContext.getBeanDefinitionNames();

//        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-applicationContext.xml");
//        Object user= context.getBean("userController");
//        String[] str=context.getBeanDefinitionNames();
//        for (String string : str) {
//            System.out.println("..."+string);
//        }
//        System.out.println("----"+user);

        if (!CollectionUtils.isEmpty(expressBeans)) {
            for (ExpressBean expressBean : expressBeans) {
                System.out.println(expressBean.toString());
                LogUtils.debug("expressBean","======expressBean=======" + expressBean.toString());
            }
            empService.insertExpress(expressBeans);
        }
        return null;
    }
}
