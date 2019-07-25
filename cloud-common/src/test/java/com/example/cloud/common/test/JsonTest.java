package com.example.cloud.common.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.cloud.common.io.ExpressBean;
import com.example.cloud.common.util.JsonUtil;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;

import javax.swing.text.html.parser.Entity;
import java.util.Map;

public class JsonTest {

    @Test
    public void jsonTest() {
        String json = "{\"code\":200,\"errorMsg\":\"\",\"result\":[{\"djxh\":\"10114403000026731548\",\"nsrsbh\":\"92440300L83529307M\",\"shxydm\":\"92440300L83529307M\",\"jdDm\":\"201901\",\"skssqq\":\"2019-01-01\",\"skssqz\":\"2019-03-31\",\"zyfpzkbhsxseHw\":\"0\",\"zyfpzkbhsxseFw1\":\"0\",\"zyfpzkbhsxseFw2\":\"0\",\"zyfpdkbhsxseHw\":\"0\",\"zyfpdkbhsxseFw1\":\"0\",\"zyfpdkbhsxseFw2\":\"0\",\"ptfpzkbhsxseHw\":\"0\",\"ptfpzkbhsxseFw1\":\"0\",\"ptfpzkbhsxseFw2\":\"0\",\"ptfpdkbhsxseHw\":\"83599.03\",\"ptfpdkbhsxseFw1\":\"0\",\"ptfpdkbhsxseFw2\":\"0\",\"kpxtmsxse\":\"0\",\"wlfp\":\"0\",\"zyfpzkbhsxse\":\"0\",\"ptfpzkbhsxse\":\"0\",\"zyfpdkbhsxse\":\"0\",\"ptfpdkbhsxse\":\"83599.03\",\"sjjcpch\":\"2019-06-21 12:50:30\",\"sjjcsj\":\"2019-06-21 12:50:30\",\"jdcfp\":\"Z\",\"cbzt\":\"Z\",\"hyzp\":\"Z\",\"jsfp\":\"Z\",\"dzfp\":\"Z\"}]}";
        JSONObject jsonToObject = JsonUtil.getJsonToObject(json);
        System.out.println(jsonToObject);
        Object result = jsonToObject.get("result");
        System.out.println();
        System.out.println(result);
        JSONArray objects = JSONObject.parseArray(result.toString());
        for (Object object : objects) {
//            System.out.println(object + "\n");
            Map<String,String> map = (Map<String,String>)object;
            System.out.println(map + "\n");
            System.out.println("ptfpdkbhsxseHw:" + map.get("ptfpdkbhsxseHw"));
        }


//        JSONObject object = JSONObject.parseObject(json);
//        String code = object.getString("code");
//        System.out.println(code);
//        String errorMsg = object.getString("errorMsg");
//        System.out.println(errorMsg);
//        Object result = object.get("result");
//        JSONArray objects = JSONObject.parseArray(result.toString());
//        System.out.println("=====objects=====" + objects);
//        List<Map<String,String>> mapList = new ArrayList<>();
//        for (Object o : objects) {
//            Map<String,String> map = (Map<String,String>)o;
//            System.out.println("------------map---------" + map);
//            System.out.println("map.get(\"skssqq\")==========" + map.get("skssqq"));
//            mapList.add(map);
//        }
    }

    @Test
    public void jsonToBeanTest(){
        ExpressBean expressBean = new ExpressBean("123456789", "小春", 12, "外卖", "微课有限公司");
        String s = JSONObject.toJSONString(expressBean);
        System.out.println(s);
//        ExpressBean parse = (ExpressBean)JSONObject.parse(s);
        ExpressBean expressBean1 = JSONObject.parseObject(s, new TypeReference<ExpressBean>() {
        });
        System.out.println(expressBean1);
        Class<ExpressBean> expressBeanClass = ExpressBean.class;
        ExpressBean value = JsonTest.getValue(s,expressBeanClass);
        System.out.println("value:" + value);
        ExpressBean expressBean2 = JSONObject.parseObject(s, ExpressBean.class);
        System.out.println(expressBean2);
    }

    public static <V> V getValue(String s,Class clazz) {
        Object o = JSONObject.parseObject(s,clazz);
//        System.out.println(v);
//        v = JSONObject.parseObject(s, new TypeReference<V>() {
//        });
        System.out.println(o);
        return (V)o;
    }
}
