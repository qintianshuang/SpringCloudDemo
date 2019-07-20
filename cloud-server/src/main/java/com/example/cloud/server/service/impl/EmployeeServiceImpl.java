package com.example.cloud.server.service.impl;

import com.example.cloud.common.io.Employee;
import com.example.cloud.common.io.ExpressBean;
import com.example.cloud.common.service.EmployeeService;
import com.example.cloud.server.mapper.ExpressDaoMapper;
import com.example.cloud.service.util.RandomUtils;
import com.example.cloud.service.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "empService")
public class EmployeeServiceImpl implements EmployeeService {
//
////    @Autowired
////    private IEmployeeRepository employeeRepository;
//
//    @Autowired
//    private RedisUtil redisUtil;
//
//    @Autowired
//    private ExpressDaoMapper expressMapper;
//
//    @Override
//    public List<Employee> queryEmployee() {
////        List<Employee> employeeList = expressMapper.queryEmployee();
////        System.out.println(employeeList);
////        return employeeList;
//        return null;
//    }
//
//    //
//    @Override
//    public List<ExpressBean> queryExpress() {
////        List<ExpressBean> expressBeanList = expressMapper.queryExpress();
////        System.out.println(expressBeanList);
////        return expressBeanList;
//        return null;
//    }
//
//    /***
//     *
//     * @param expressBeans
//     */
//    @Override
//    public void insertExpress(List<ExpressBean> expressBeans) {
//        String k = "apple";
////        System.out.println(redisUtil.toString());
////        Object value = redisUtil.getValue(k);
//        String value = "";
//        System.out.println("------shardedJedisStr--------" + value + "--------------");
//        System.out.println("------shardedJedisStr--------" + value + "--------------");
//        System.out.println("-------jedisStr-------" + value + "--------------");
//        System.out.println("-------jedisStr-------" + value + "--------------");
//
////        List<ExpressBean> expressBeans = new ArrayList<>();
//        String s = "";
////        RandomUtils.randomID();
//        System.out.println(s);
//
//        expressBeans.add(new ExpressBean(RandomUtils.randomID(), "小春", 12, "外卖", "微课有限公司"));
//        expressBeans.add(new ExpressBean(RandomUtils.randomID(), "小红", 13, "文员", "墨色有限公司"));
//        expressBeans.add(new ExpressBean(RandomUtils.randomID(), "小绿", 14, "工程师", "太阳有限公司"));
//        expressBeans.add(new ExpressBean(RandomUtils.randomID(), "小紫", 15, "教练", "噢噢有限公司"));
//
//        //查出数据库中已经存在的信息
////        List<ExpressBean> expressBeanList = expressMapper.queryExpress();
////        Map<String, ExpressBean> map = new HashMap<>();
////        //将查出来的数据放入map中
////        for (ExpressBean expressBean : expressBeanList) {
////            map.put(expressBean.getEmpNo(), expressBean);
////        }
////        List<ExpressBean> expressBeanArrayList = new ArrayList<>();
////
////        //遍历要插入的数据
//        if (!CollectionUtils.isEmpty(expressBeans)) {
//            for (int i = 0; i < expressBeans.size(); i++) {
//                //对比数据库的数据，过滤点重复的数据
//                if (StringUtils.isEmpty(map.get(expressBeans.get(i).getEmpNo()))) {
//                    //将不存在的新数据保存到新集合
//                    expressBeanArrayList.add(expressBeans.get(i));
//                }else {
//                    System.out.println(expressBeans.get(i));
//                }
//            }
//        }
//
//        System.out.println(expressBeanArrayList);
//        if (!CollectionUtils.isEmpty(expressBeanArrayList)) {
//            //如果新数据不为空，插入到数据库
//            Integer index = expressMapper.insertExpress(expressBeanArrayList);
//            System.out.println(index);
//            for (ExpressBean expressBean : expressBeanArrayList) {
//                String key = "emp" + expressBean.getEmpNo() + "info";
//                redisUtil.setValue(key,expressBean);
//            }
//        }
    }
}
