package com.example.cloud.common.util;

import com.alibaba.fastjson.JSONObject;

public class JsonUtil {

//    public static void main(String[] args) {
//        String json = "{\"code\":200,\"errorMsg\":\"\",\"result\":[{\"djxh\":\"10114403000026731548\",\"nsrsbh\":\"92440300L83529307M\",\"shxydm\":\"92440300L83529307M\",\"jdDm\":\"201901\",\"skssqq\":\"2019-01-01\",\"skssqz\":\"2019-03-31\",\"zyfpzkbhsxseHw\":\"0\",\"zyfpzkbhsxseFw1\":\"0\",\"zyfpzkbhsxseFw2\":\"0\",\"zyfpdkbhsxseHw\":\"0\",\"zyfpdkbhsxseFw1\":\"0\",\"zyfpdkbhsxseFw2\":\"0\",\"ptfpzkbhsxseHw\":\"0\",\"ptfpzkbhsxseFw1\":\"0\",\"ptfpzkbhsxseFw2\":\"0\",\"ptfpdkbhsxseHw\":\"83599.03\",\"ptfpdkbhsxseFw1\":\"0\",\"ptfpdkbhsxseFw2\":\"0\",\"kpxtmsxse\":\"0\",\"wlfp\":\"0\",\"zyfpzkbhsxse\":\"0\",\"ptfpzkbhsxse\":\"0\",\"zyfpdkbhsxse\":\"0\",\"ptfpdkbhsxse\":\"83599.03\",\"sjjcpch\":\"2019-06-21 12:50:30\",\"sjjcsj\":\"2019-06-21 12:50:30\",\"jdcfp\":\"Z\",\"cbzt\":\"Z\",\"hyzp\":\"Z\",\"jsfp\":\"Z\",\"dzfp\":\"Z\"}]}";
//        JSONObject object = JSONObject.fromObject(json);
//        String code = object.getString("code");
//        String errorMsg = object.getString("errorMsg");
//        System.out.println(code);
//        System.out.println(errorMsg);
//    }

    public static JSONObject getJsonToObject(String json){
        JSONObject object = JSONObject.parseObject(json);
        return object;
    }

    public static void main(String[] args) {

    }
}
