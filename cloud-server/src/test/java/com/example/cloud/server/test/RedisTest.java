package com.example.cloud.server.test;

import com.example.cloud.service.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

//import com.example.cloud.service.util.RedisUtil;


public class RedisTest {

//    @Autowired
//    private RedisUtil redisUtil;

    @Autowired
    private IEmployeeService employeeService;
    //
    //@Test
    //public void test(){
    //    boolean apple = redisUtil.exists("apple");
    //    System.out.println(apple);
    //    Object apple1 = redisUtil.get("apple");
    //    System.out.println(apple1);
    //}

//        @Test
        /**
         * 连接池连接方式
         */
//        public void demo2(){
//
//            List<ExpressBean> expressBeans = new ArrayList<>();
//            expressBeans.add(new ExpressBean("11111","小春",12,"外卖","微课有限公司"));
//            expressBeans.add(new ExpressBean("22222","小红",13,"文员","墨色有限公司"));
//            expressBeans.add(new ExpressBean("33333","小绿",14,"工程师","太阳有限公司"));
//            expressBeans.add(new ExpressBean("44444","小紫",15,"教练","噢噢有限公司"));
//
//            employeeService.insertExpress(expressBeans);
//            Object qq = redisUtil.getValue("qq");
//            System.out.println(qq.toString());
//    }
}
