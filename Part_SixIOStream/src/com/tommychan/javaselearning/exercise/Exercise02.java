package com.tommychan.javaselearning.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercise02 {
    public static void main(String[] args) throws IOException {

        String path = "d:\\tempFiles\\test1.txt";

        BufferedReader bfr = new BufferedReader(new FileReader(path));

        String line = "";
        int i = 1;

        while ((line = bfr.readLine())!=null){
            System.out.print((i++)+line);
        }

        bfr.close();
    }
}
