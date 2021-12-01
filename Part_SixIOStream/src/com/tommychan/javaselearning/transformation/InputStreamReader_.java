package com.tommychan.javaselearning.transformation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
  * @author TommyChan
  * @version 1.0
  * description: 使用 InputStreamReader 将字节流转换为字符流
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {

        String filePath = "d:\\tempFiles\\test1.txt";
        //用InputStreamReader将字节流转换为字符流 并指定读取的编码格式
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath),"gbk");

        BufferedReader br = new BufferedReader(isr);
        //读取
        String s = br.readLine();
        System.out.println(s);

        //关闭外层流
        br.close();

    }
}
