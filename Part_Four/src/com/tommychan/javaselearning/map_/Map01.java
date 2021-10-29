package com.tommychan.javaselearning.map_;

import java.util.HashMap;
import java.util.Map;

public class Map01 {
    public static void main(String[] args) {
        //1.Map用于保存具有映射关系的数据：Key — Value
        Map map = new HashMap();
        map.put("no1","tommy");
        map.put("no2","henry");

        System.out.println(map);
        //2.Map中的key和 value 可以是任何引用类型的数据，会封装到HashMap$Node对象中
        //3.Map中的key不允许重复，原因和HashSet一样，前面分析过源码,当有相同的k时会用相应的v替代
        map.put("no1","mary");
        System.out.println(map);

        //4.Map中的value可以重复
        map.put("no3","henry");
        System.out.println(map);

        //5.Map的key可以为null， value也可以为null，注意key为null，只能有一个 ; value为null, 可以多个
        map.put(null,"000");
        System.out.println(map);
        map.put(null,null);
        System.out.println(map);

        map.put("no4",null);
        map.put("no5",null);
        System.out.println(map);

        //6.常用String类作为Map的key

        //7.key和value之间存在单向一对一关系，即通过指定的key总能找到对应的value
        System.out.println("no3:"+map.get("no3"));


    }
}
