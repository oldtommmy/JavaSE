package com.tommychan.javaselearning.iostream_;

import org.junit.jupiter.api.Test;

import java.io.File;

public class Directory_ {
    public static void main(String[] args) {

    }

    @Test
    public void m1(){

        String pathName = "d:\\tempFiles\\txtFiles";
        File file = new File(pathName);

        String pathName02 = "d:\\txtFiles";
        File file1 = new File(pathName02);

        if (file.exists()){
            System.out.println("Directory existed");
        }else{
            file.mkdirs();//创建多级目录用 mkdirs()
            System.out.println("Can't find this Directory ... Created successfully");
        }

        if (file1.exists()){
            System.out.println("Directory existed");
        }else{
            file1.mkdir();//创建一级目录用 mkdir()
            System.out.println("Can't find this Directory ... Created successfully");
        }
    }
}
