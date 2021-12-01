package com.tommychan.javaselearning.properties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * @author TommyChan
 * @version 1.0
 * description 传统方法读取
 */
public class Properties01 {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new FileReader("src\\mysql.properties"));
        String line = "";
        while ((line = bfr.readLine())!=null){
            String[] spilt = line.split("=");
            System.out.println(spilt[0]+"的值是"+spilt[1]);
        }
        bfr.close();
    }
}