package com.tommychan.learning.singleTon;

public class singleTon02 {
    public static void main(String[] args) {
        System.out.println(BoyFriend.n); //此时并没有初始化对象boyFriend 也没有调用构造器
        System.out.println("================");
        System.out.println(BoyFriend.getInstance().toString()); //初始化boyFriend ->调用构造器
        System.out.println("================");
        System.out.println(BoyFriend.getInstance().toString()); //再次调用 此时不会再调用构造器
    }
}

//［懒汉式］步骤：
//1．仍然将构造器私有化
//2．定义一个static的对象
//3．提供一个公共的static方法，可以的返回一个对象
/*  只有当调用 getInstance() 时才会调用构造器来创建对象 并返回 后面再次调用时 会放回上次创建的对象*/
class BoyFriend{
    private String name;
    public static int n = 1;
    private static BoyFriend boyFriend; //默认为 null

    private BoyFriend(String name){ //仍然将构造器私有化
        System.out.println("Constructor is called");
        this.name = name;
    }

    public static BoyFriend getInstance(){ //提供一个公共的static方法，可以的返回一个对象
        if (boyFriend == null){
            boyFriend = new BoyFriend("Tommy");
        }
        return boyFriend;
    }

    @Override
    public String toString() {
        return "BoyFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}