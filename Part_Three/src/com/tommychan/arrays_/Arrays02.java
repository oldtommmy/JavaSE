package com.tommychan.arrays_;

import java.util.Arrays;
import java.util.Comparator;

public class Arrays02 {
    public static void main(String[] args) {
        Book book = new Book("Bill Gates", 30.5);
        Book book1 = new Book("Old Tommy", 18.5);
        Book book2 = new Book("Miracle",45);

        Book[] books = new Book[3];
        books[0] = book;
        books[1] = book1;
        books[2] = book2;

        //接口编程＋动态绑定＋匿名内部类的综合使用
        Arrays.sort(books, new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        Book book1 = (Book) o1;
                        Book book2 = (Book) o2;
                        double flag = book1.getPrice()-book2.getPrice(); //不要用强转
                        if (flag > 0) {                                  //会有漏洞
                            return 1;     // >0  即可                     //如 30.1-30=0.1
                        }else if (flag == 0){                            //(int)0.1 = 0
                            return 0;
                        }else {
                            return -1;  // <0 即可
                        }
                    }
                });

        System.out.println(Arrays.toString(books));

    }
}

class Book {
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
