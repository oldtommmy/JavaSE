package com.tommychan.javaselearning.set_;

import com.tommychan.javaselearning.collection_.Iterator_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *  以 HashSet 来实现 Set 的部分方法
 */
public class SetMethod {
    public static void main(String[] args) {

        Set set = new HashSet();
        set.add("tom");
        set.add("jack");
        set.add("mary");
        set.add(null);
        //set 接口的实现类的对象（Set接口对象），不能存放重复的元素，可以添加一个null
        //set 接口对象存放数据是无序（即添加的顺序和取出的顺序不一致 但取出的顺序是固定的）

        System.out.println(set);
        System.out.println(set);
        System.out.println("=================");

        //删除方法
        set.remove(null);
        System.out.println(set);
        System.out.println("=================");
        //1 迭代器遍历
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }

        System.out.println("\n=================");
        //2 增强for遍历
        for (Object name:set) {
            System.out.print(name+" ");
        }

        //3 不可通过索引遍历
    }
}
