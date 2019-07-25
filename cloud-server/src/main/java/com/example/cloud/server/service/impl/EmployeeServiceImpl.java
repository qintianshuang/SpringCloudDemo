package com.example.cloud.server.service.impl;

import com.example.cloud.common.config.Logger;
import com.example.cloud.common.io.Employee;
import com.example.cloud.common.io.ExpressBean;
import com.example.cloud.common.util.JsonUtil;
import com.example.cloud.server.mapper.ExpressDaoMapper;
import com.example.cloud.service.service.IEmployeeService;
import com.example.cloud.service.util.RandomUtils;
import com.example.cloud.service.util.RedisUtil;
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
    private ExpressDaoMapper expressMapper;

    /***
     *
     * @return
     */
    @Override
    public List<Employee> queryEmployee() {
        List<Employee> employeeList = expressMapper.queryEmployee();
        log.debug("employeeList" + employeeList);
        return employeeList;
    }

    /***
     *
     * @return
     */
    @Override
    public List<ExpressBean> queryExpress() {
        List<ExpressBean> expressBeanList = expressMapper.queryExpress();
        log.debug("expressBeanList" + expressBeanList);
        return expressBeanList;
    }

    /***
     *
     * @param expressBeans
     */
    @Override
    public void insertExpress(List<ExpressBean> expressBeans) {
        log.debug("expressBeanList||" + redisUtil.toString());
        redisUtil.setValue("apple","apple");
        redisUtil.setValue("banana","banana");
        Object apple = redisUtil.getValue("apple");
        Object banana = redisUtil.getValue("banana");
        log.debug("expressBeanList||" + apple + "--------------");
        log.debug("expressBeanList||" + banana + "--------------");
        for (ExpressBean expressBean : expressBeans) {
            expressBean.setEmpNo(RandomUtils.randomID());
        }
        //查出数据库中已经存在的信息
        List<ExpressBean> expressBeanList = expressMapper.queryExpress();
        Map<String, ExpressBean> map = new HashMap<>();
        //将查出来的数据放入map中
        for (ExpressBean expressBean : expressBeanList) {
            map.put(expressBean.getEmpNo(), expressBean);
        }
        List<ExpressBean> expressBeanArrayList = new ArrayList<>();
//        //遍历要插入的数据
        if (!CollectionUtils.isEmpty(expressBeans)) {
            for (int i = 0; i < expressBeans.size(); i++) {
                //对比数据库的数据，过滤点重复的数据
                if (StringUtils.isEmpty(map.get(expressBeans.get(i).getEmpNo()))) {
                    //将不存在的新数据保存到新集合
                    expressBeanArrayList.add(expressBeans.get(i));
                }else {
                    log.debug("expressBeanList||" + expressBeans.get(i));
                }
            }
        }

        log.debug("expressBeanArrayList||" + expressBeanArrayList);
        if (!CollectionUtils.isEmpty(expressBeanArrayList)) {
            //如果新数据不为空，插入到数据库
            Integer index = expressMapper.insertExpress(expressBeanArrayList);
            log.debug("expressBeanList||" + index);
            for (ExpressBean expressBean : expressBeanArrayList) {
                String key = "emp" + expressBean.getEmpNo() + "info";
                log.debug("JsonUtil.getObjectToJson(expressBean)||" + JsonUtil.getObjectToJson(expressBean));
                redisUtil.setValue(key,JsonUtil.getObjectToJson(expressBean));
            }
            for (ExpressBean expressBean : expressBeanArrayList) {
                String key = "emp" + expressBean.getEmpNo() + "info";
                Object value = redisUtil.getValue(key,ExpressBean.class);
                log.debug("value||" + value);
            }
        }
    }
}
