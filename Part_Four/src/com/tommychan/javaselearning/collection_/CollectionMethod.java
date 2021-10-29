package com.tommychan.javaselearning.collection_;

import java.util.ArrayList;
import java.util.List;

public class CollectionMethod {
    public static void main(String[] args) {

        List list = new ArrayList();
        //add：添加单个元素
        list.add(18);
        list.add(29);
        System.out.println(list);

        //remove(index)：删除index处的元素
        list.remove(0);
        System.out.println(list);

        //contains：查找元素是否存在
        System.out.println(list.contains(9));

        //size：获取元素个数
        System.out.println(list.size());

        //isEmpty：判断是否为空
        System.out.println(list.isEmpty());

        //clear：清空
        list.clear();

        //addALL：添加多个元素
        List list1 = new ArrayList();
        list1.add("tommy");
        list1.add("eric");
        list.addAll(list1);
        System.out.println(list);

        //containsALL：查找多个元素是否都存在
        System.out.println(list.containsAll(list1));

        //removeALL：删除多个元素
        list.removeAll(list1);
    }
}
