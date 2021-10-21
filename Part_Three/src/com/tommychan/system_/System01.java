package com.tommychan.system_;

import java.util.Arrays;

/**
 * System 类的常用方法
 */
public class System01 {
    public static void main(String[] args) {

        //1. exit 退出程序
        System.out.println("hello");
        //System.exit(0); //参数 0 表示正常退出

        //2. arraycopy 拷贝数组
        int[]src = {1,2,3};
        int[]dest = new int[3];
        System.arraycopy(src,0,dest,0,3);
        //参数解读： (源数组 , 源数组开始拷贝的索引 , 目标数组 , 目标数组开始参加拷贝的索引 , 拷贝数据的个数 )
        System.out.println(Arrays.toString(dest));

        //3. currentTimeMillis 返回当前时间距离1970-1-1的毫秒数
        System.out.println(System.currentTimeMillis());

        //4. gc 运行垃圾回收机制 System.gc（）;
    }
}
