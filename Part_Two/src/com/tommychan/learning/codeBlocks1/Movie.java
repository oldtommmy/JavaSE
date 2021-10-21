package com.tommychan.learning.codeBlocks1;

public class Movie {
    private String name;
    private double price;

    {
        System.out.println("电影即将开始");
        System.out.println("广告时间");
        System.out.println("电影正式开始");
    };
//    下面的三个构造器都有相同的语句
//    这时我们可以把相同的语句，放入到一个代码块中，即可
//    这样当我们不管调用哪个构造器，创建对象，都会先调用代码块的内容代码块调用的顺序优先于构造器。。

    public Movie(String name) {
        this.name = name;
        System.out.println("public Movie(String name) is called");
    }

    public Movie(String name, double price) {
        this.name = name;
        this.price = price;
        System.out.println("public Movie(String name, double price) is called");
    }

}
