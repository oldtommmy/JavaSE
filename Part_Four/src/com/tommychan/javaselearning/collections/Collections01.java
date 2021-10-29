package com.tommychan.javaselearning.collections;

import java.util.*;

import static java.util.Collections.*;

@SuppressWarnings({"all"})
public class Collections01 {
    public static void main(String[] args) {

        List arrayList = new ArrayList();
        arrayList.add("tommy");
        arrayList.add("ann");
        arrayList.add("jack");

        System.out.println(arrayList);

        //reverse（List）：反转List中元素的顺序
        reverse(arrayList);
        System.out.println(arrayList);

        //shuffle（List）：对 List集合元素进行随机排序
        shuffle(arrayList);
        System.out.println(arrayList);

        //sort（List）：根据元素的自然顺序对指定List集合元素按升序排序
        sort(arrayList);
        System.out.println(arrayList);

        //sort（List，Comparator）：根据指定的 Comparator 产生的顺序对List集合元素进行 排序
        sort(arrayList, new Comparator() {
            @Override
            public int compare(Object o1,Object o2){
                return ((String)o1).length()-((String)o2).length();
            }
        });
        System.out.println(arrayList);

        //swap（List， int， int）：将指定list集合中的i处元素和j处元素进行交换
        Collections.swap(arrayList,0,2);
        System.out.println(arrayList);

        //Object max（Collection）：根据元素的自然顺序，返回给定集合中的最大元素
        System.out.println("nature_max="+max(arrayList));

        //Object max(Collection, Comparator):根据Comparator指定的顺序, 返回给定集合中的最大元素
        System.out.println("certain_max(length)="+max(arrayList, new Comparator() {
            @Override
            public int compare(Object o1,Object o2){
                return ((String)o1).length()-((String)o2).length();
            }
        }));

        //Object min(Collection)
        System.out.println("nature_min="+min(arrayList));

        //Object min(Collection, Comparator)
        System.out.println("certain_min(length)="+min(arrayList, new Comparator() {
            @Override
            public int compare(Object o1,Object o2){
                return ((String)o1).length()-((String)o2).length();
            }
        }));

        //int frequency（Collection，Collection）：返回指定集合中指定元素的出现次数
        System.out.println("tommy_times="+frequency(arrayList,"tommy"));

        //void copy（List dest，List src）：将src中的内容复制到dest中
        List list = new ArrayList(); //为了完整拷贝 我们先要给list赋值 大小与arrayList().size一样
        for (int i = 0; i < arrayList.size(); i++) {
            list.add("");
        }
        copy(list,arrayList);
        System.out.println(list);

        //boolean replaceAll（List list， Object oldVal， Object newVal）：使用新值替换List对象的所有旧值
        replaceAll(arrayList,"tommy","Tommy");
        System.out.println(arrayList);

    }
}


