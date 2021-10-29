package com.tommychan.javaselearning.set_;

import sun.reflect.generics.tree.Tree;

import java.util.Comparator;
import java.util.TreeSet;

@SuppressWarnings({"all"})
public class TreeSet_ {
    public static void main(String[] args) {

        //1.使用无参构造器创建TreeSet时 是默认按字母表排序
        //2.若希望改变排序规则，可用TreeSet提供的构造器，传入一个比较器（使用到匿名内部类）

        //(1)按字母表排序
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o2).compareTo((String)o1);
            }
        });

        //(2)按长度排序
        TreeSet treeSet1 = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length()-((String)o2).length();
            }
        });

        treeSet.add("tommy");
        treeSet.add("jack");
        treeSet.add("kevin");
        treeSet.add("mary");

        treeSet1.add("tom");
        treeSet1.add("jackson");
        treeSet1.add("kevin");
        treeSet1.add("mary");

        System.out.println(treeSet);
        System.out.println(treeSet1);

    }
}
