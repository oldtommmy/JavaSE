package com.tommychan.javaselearning.map_;


import java.util.*;

public class MapFor {
    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("No1","Tommy");
        map.put("No2","Henry");
        map.put("No3","Jack");
        map.put("No4","Jason");
        map.put(null,"Ron");

        //用到的方法：
        //containsKey：查找键是否存在
        //keySet：获取所有的键
        //entrySet：获取所有关系k—v
        //values：获取所有的值

        //Map.Entry 中的方法
        //getKey
        //getValue

        //第一组 ： 先取出所有的key 再通过key取出value 实质是Set的遍历
        Set keyset = map.keySet();
        //(1)用增强for
        System.out.println("==========way 1=============");
        for (Object key:keyset){
            System.out.print(map.get(key)+" ");
        }
        //(2)用迭代器
        System.out.println("\n==========way 2=============");
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()){
            System.out.print(map.get(iterator.next())+" ");
        }

        //第二组 ： 把所有的value取出来
        Collection values = map.values();
        //(1)for循环 与 (2)增强for都可以
        System.out.println("\n========way 3 & 4===========");
        for (Object o:values) {
            System.out.print(o+" ");
        }
        //(2)迭代器
        System.out.println("\n==========way 5=============");
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()){
            System.out.print(iterator1.next()+" ");
        }

        //第三组 ： 通过EntrySet
        Set entrySet = map.entrySet();
        //(1)增强for
        System.out.println("\n==========way 6=============");
        for (Object o:entrySet) {
            //o 运行的类型是HashMap$Node
            //我们将它转为Map.Entry才可以使用getKey() getValue()
            Map.Entry entry = (Map.Entry) o;
            System.out.print(entry.getKey()+"-"+entry.getValue()+" ");
        }

        //(2)迭代器
        System.out.println("\n==========way 7=============");
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()){
            //iterator2.next()的类型是HashMap$Node (实现了Map.Entry接口)
            //我们将它转为Map.Entry才可以使用getKey() getValue()
            Map.Entry entry = (Map.Entry) iterator2.next();
            System.out.print(entry.getKey()+"-"+entry.getValue()+" ");
        }
    }
}
