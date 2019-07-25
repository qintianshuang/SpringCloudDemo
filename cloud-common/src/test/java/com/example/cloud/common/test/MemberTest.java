package com.example.cloud.common.test;

import java.util.*;

public class MemberTest {

    private static void sortMapValue(){
        Map<String,Integer> map =new HashMap<>();
        map.put("a",2);
        map.put("c",57);
        map.put("d",6);
        map.put("b",83);
        //map.put("KFC", "kfc");
        //map.put("WNBA", "wnba");
        //map.put("NBA", "nba");
        //map.put("CBA", "cba");
        List<Map.Entry<String,Integer>> lstEntry=new ArrayList<>(map.entrySet());
        Collections.sort(lstEntry,((o1, o2) -> {
            return o1.getValue().compareTo(o2.getValue());
        }));
        lstEntry.forEach(o->{
            System.out.println(o.getKey()+":"+o.getValue());
        });

    //    //如果一定要返回一个map，就new一个LinkedHashMap，将list中所有值依次put进去就可以
    //LinkedHashMap<String,String> linkedHashMap=new LinkedHashMap<>();
    //lstEntry.forEach(o->{
    //    linkedHashMap.put(o.getKey(),o.getValue());
    //});

    }

    public static void main(String[] args) {
        sortMapValue();
    }
}
