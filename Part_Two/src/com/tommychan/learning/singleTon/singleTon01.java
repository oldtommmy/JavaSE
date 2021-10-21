package com.tommychan.learning.singleTon;

public class singleTon01 {
    public static void main(String[] args) {
        System.out.println(GirlFriend.getInstance().toString());;
    }
}

//步骤［单例模式—饿汉式］
// 1．将构造器私有化
// 2．在类的内部直接创建对象（该对象是static）
// 3．提供一个公共的static方法，返回 girlFriend对象

class GirlFriend{

    private String name;
    //在类的内部直接创建对象（该对象是static）
    //对象girlFriend为什么用static ：因为返回的对象的方法是静态方法 只能访问静态变量
    private static GirlFriend girlFriend = new GirlFriend("Julia");

    private GirlFriend(String name){         //将构造器私有化
        this.name = name;
    }

    //方法为什么用static ：因为该单例模式会组织用户在类外 new 对象
    //没有对象的情况下 只可用 类名.方法名() 来调用静态方法
    public static GirlFriend getInstance(){  //提供一个公共的static方法，返回 girlFriend对象
        return girlFriend;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}