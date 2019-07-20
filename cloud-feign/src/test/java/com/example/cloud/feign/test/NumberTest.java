package com.example.cloud.feign.test;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberTest {

    private static byte[] lock = new byte[0];

    // 位数，默认是8位
    private final static long w = 100000000;



    @Test
    public void test1() {
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 1000000; i++) {
            //long t3 = System.currentTimeMillis();
            //int aa = (int) (Math.random() * (500 - 100) + 100);
            //int bb = (int) (Math.random() * (1000 - 500) + 100);
            //String str = t3 + "" + aa + "" + bb;
            long r = 0;
            synchronized (lock) {
                r = (long) ((Math.random() + 1) * w);
            }
            String str = System.currentTimeMillis() + String.valueOf(r).substring(1);
            if (!StringUtils.isEmpty(map.get(str))){
                str = str + "重复了";
               list.add(str) ;
            }else {
                map.put(str,str);
            }
            System.out.println(str);
        }
        System.out.println(list);
    }


    @Test
    public void test2(){
        long r = 0;
        synchronized (lock) {
            r = (long) ((Math.random() + 1) * w);
        }

        String s = System.currentTimeMillis() + String.valueOf(r).substring(1);
        System.out.println(s);
    }
}
