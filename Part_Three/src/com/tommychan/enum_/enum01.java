package com.tommychan.enum_;

import java.util.Scanner;

/**
 * 自定义枚举类的描述
 */
public class enum01 {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
    }
}

class Season {
    private String name;
    private String desc;

    //1.将构造器私有化 防止直接被 new 出来
    //2.不要用setXXX方法 防止更改属性 get可有
    //3.在内部直接创建固有对象
    //4.用final+static实现底层优化 避免类加载
    public final static Season SPRING = new Season("Spring","Warm");
    public final static Season WINTER = new Season("Winter","Cold");
    public final static Season SUMMER = new Season("Summer","Hot");
    public final static Season FALL = new Season("Fall","Cool");


    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

