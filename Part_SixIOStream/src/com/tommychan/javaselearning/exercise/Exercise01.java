package com.tommychan.javaselearning.exercise;

import java.io.File;
import java.io.IOException;

public class Exercise01 {
    public static void main(String[] args) throws IOException {

        String filePath = "d:\\tempFiles\\Files";
        File file = new File(filePath);
        if (!file.exists()){
            file.mkdirs();
            System.out.println("Files is created successfully");
        }else {
            System.out.println("Files has existed");
        }

        String newFile = "d:\\tempFiles\\Files\\hello.txt";
        File file1 = new File(newFile);
        if (!file1.exists()){
            file1.createNewFile();
            System.out.println("hello.txt is created successfully");
        }else {
            System.out.println("hello.txt has existed");
        }
    }
}
