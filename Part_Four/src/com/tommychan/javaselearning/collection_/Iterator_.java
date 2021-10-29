package com.tommychan.javaselearning.collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterator_ {
    public static void main(String[] args) {

        List bookList = new ArrayList();
        bookList.add(new Book("Green Book",30.5));
        bookList.add(new Book("TomRiddle's Diary", 12));

        Iterator iterator = bookList.iterator();

        while (iterator.hasNext()){//快捷键 itit 可以快速生成while来用迭代器遍历
            Object object = iterator.next();
            System.out.println(object); //默认调用toString方法
        }

        //退出while循环后 迭代器指向最后的元素
        //如要再次使用迭代器 需要重置迭代器
        iterator = bookList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

    }
}

class Book{
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
