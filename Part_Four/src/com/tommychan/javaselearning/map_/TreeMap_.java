package com.tommychan.javaselearning.map_;

import java.util.Comparator;
import java.util.TreeMap;

@SuppressWarnings({"all"})

public class TreeMap_ {
    public static void main(String[] args) {

        //使用默认构造器
        //TreeMap treeMap = new TreeMap();
        //treeMap.put("Jack","杰克");
        //treeMap.put("Tom","汤姆");
        //treeMap.put("Mary","玛丽");
        //无排序规则
        //System.out.println(treeMap);

        //带比较器的构造器
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //return ((String)o1).compareTo((String)o2); 举例 ：按照传入的key(String)的默认比较方式
                return ((String)o1).length()-((String)o2).length(); //按照传入的key(String)的长度
            }
        });
        treeMap.put("Jack","杰克");
        treeMap.put("Tom","汤姆");
        treeMap.put("Mary","玛丽");

        System.out.println(treeMap);
    }
}
