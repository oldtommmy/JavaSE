package com.tommychan.javaselearning.list_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class List01 {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("tom");
        list.add("mike");
        list.add("jack");
        list.add("mike");

        //void add（int index， Object ele）
        //在index位置插入ele元素 原index处及之后的元素后移
        list.add(2,"mary");
        System.out.println(list);

        //size() 返回list的元素个数
        System.out.println(list.size());

        //boolean addAll（int index，Collection eles）：从index位置开始将 eles中的所有元素添加进来
        Collection collection = new ArrayList();
        collection.add("Chan");
        list.addAll(4,collection);
        System.out.println(list);

        //Object get（int index）：获取指定index位置的元素
        Object o1 = list.get(3);
        System.out.println(o1);

        //int indexOf（Object obj）：返回obj在集合中首次出现的位置
        System.out.println(list.indexOf("mike"));

        //int lastlndexOf（Object obj）：返回obj在当前集合中末次出现的位置
        System.out.println(list.lastIndexOf("mike"));

        //Object remove（int index）：移除指定index位置的元素，并返回此元素
        System.out.println(list.remove(5));
        System.out.println(list);

        //Object set（int index，Object ele）：设置指定index位置的元素为ele， 相当于是替换
        list.set(3,"jackson");
        System.out.println(list);

        //List subList（int fromlndex，int tolndex）：返回从fromlndex到 tolndex位置的子集合
        System.out.println(list.subList(0,3));

        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            System.out.println(obj);
        }

 
    }
}
