package com.tommychan.enum_Method;


public class Enum_Method {
    public static void main(String[] args) {
        Season02 winter = Season02.WINTER;
        //toString()返回当前对象名
        System.out.println(winter.toString());
        System.out.println("===================");
        //name()返回当前对象名（常量名） ，子类中不能重写
        System.out.println(winter.name());
        System.out.println("===================");
        //以数组形式返回当前枚举类中所有的常量
        Season02[] values = Season02.values();
        //增强for
        for (Season02 season02 : values){
            System.out.println(season02);
        }
        System.out.println("===================");
        //ordinal()返回当前对象的位置号，默认从0开始
        //winter是第四个 所以输出3
        System.out.println("WINTER's Position:"+winter.ordinal());
        System.out.println("===================");

        //valueOf()将字符串转换成枚举对象，要求字符串必须为已有的常量名，否则报异常
        Season02 season02 = Season02.valueOf("FALL");
        System.out.println(season02);
        System.out.println("===================");

        //compareTo()比较两个枚举常量，比较的就是编号
        System.out.println(winter.compareTo(Season02.FALL));

    }
}


