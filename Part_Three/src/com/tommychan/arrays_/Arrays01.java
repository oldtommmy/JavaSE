package com.tommychan.arrays_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Arrays01 {
    public static void main(String[] args) {
        Integer[] num= {1,334,12,43,32};
        //1. toString方法可以显示数组
        System.out.println(Arrays.toString(num));

        //2. sort 排序
        //(1) 升序排序
        Arrays.sort(num);
        System.out.println(Arrays.toString(num));

        //(2)定制排序
        Arrays.sort(num, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i2-i1;
            }
        });
        System.out.println(Arrays.toString(num));

        //3. binarySearch
        // 二分搜索来查找 要求必须排好顺序
        // 不存在则返回 -(low+1) 例如：
        // 7 不在数组中 如果7存在这应该在6和88之间 故low=5 返回-6
        Integer[] nums= {1,3,4,5,6,88};
        int index = Arrays.binarySearch(nums,3);
        System.out.println("index="+index);

        //4.copyOf(nums,newLength) 使用的是底层的System.arraycopy()
        //  完成数组复制
        //  从nums拷贝newLength个元素
        //  如果 newLength > nums.length 则在末尾加上 null
        //  如果 newLength <  0 则报错 NegativeArraySizeException
        Integer[] nums2 = Arrays.copyOf(nums,6);
        System.out.println(Arrays.toString(nums2));

        //5.fill 数组填充
        //  使用99去填充原有数据
        Integer[] nums3 = {9,1,null,null};
        Arrays.fill(nums3,99);
        System.out.println(Arrays.toString(nums3)); //[99,99,99,99]

        //6.equals 比较两个数组的元素是否完全一致
        Integer[] nums4 = {99,99,99,99};
        System.out.println(Arrays.equals(nums3,nums4)); //true

        //7.asList 将一组值转换为list
        List list1 = Arrays.asList(nums4);
        List list2 = Arrays.asList(2,34,54,35);
        System.out.println("list1 = "+list1);
        System.out.println("list2 = "+list2);

    }
}
