package com.tommychan.javaselearning.map_;

import java.util.HashMap;
import java.util.Map;

public class MapMethod {
    public static void main(String[] args) {

        Map map = new HashMap();

        //put：添加
        map.put("No1","Tommy");
        map.put("No2","Henry");
        map.put(null,"Ron");
        System.out.println(map);

        //remove：根据健删除映射关系
        map.remove("No2");
        System.out.println(map);

        //get：根据key获取值
        System.out.println(map.get(null));

        //size：获取元素个数
        System.out.println(map.size());

        //isEmpty:判断个数是否为0 boolean类型
        System.out.println(map.isEmpty());

        //clear:清除
//        map.clear();
//        System.out.println(map);

        //containsKey：查找键是否存在
        System.out.println(map.containsKey("No1"));



    }
}
