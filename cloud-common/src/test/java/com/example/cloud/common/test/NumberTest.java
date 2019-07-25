package com.example.cloud.common.test;

import com.example.cloud.common.util.NumberUtil;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

public class NumberTest {

    @Test
    public void numberTest(){
//        String value = " 7.557006804684265498646843e+3 ";
//        String value = "10214403000001239434SXA031901022";
//        String value = "Y";
//        String value = "/>.,+";
        String value = null;
        boolean eNnum = NumberUtil.isENnum(value);
        System.out.println(eNnum);
        if (eNnum){
            value = value.replace(" ", "");
            System.out.println(value);
            BigDecimal bigDecimal = new BigDecimal(value);
            System.out.println(bigDecimal);
        }else {
            System.out.println("不是科学计数法！！！");
        }
    }
}
