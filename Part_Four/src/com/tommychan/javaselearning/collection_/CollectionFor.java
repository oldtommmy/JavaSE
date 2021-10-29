package com.tommychan.javaselearning.collection_;

import java.util.ArrayList;
import java.util.List;

public class CollectionFor {
    public static void main(String[] args) {
        List bookList = new ArrayList();
        bookList.add(new Book("Green Book",30.5));
        bookList.add(new Book("TomRiddle's Diary", 12));


        //增强for 在Collection集合
        for (Object book:bookList) {
            System.out.println(book);
        }
        //对数组也可以使用增强for
        int[] num = {1,3,45,63};
        for (int i:num) {
            System.out.println(i);
        }
    }
}
