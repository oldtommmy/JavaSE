package com.tommychan.javaselearning.printstream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author TommyChan
 * @version 1.0
 * description 演示 PrintWriter 的使用
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {

        PrintWriter printWriter = new PrintWriter(System.out);//传入的是标准输出 在屏幕，显示器输出
        printWriter.println("hello world");
        printWriter.close();

        PrintWriter printWriter1 = new PrintWriter(new FileWriter("d:\\tempFiles\\test1.txt"));
        printWriter1.println("hello world!!!");//输出到"d:\\tempFiles\\test1.txt"
        printWriter1.close();//一定要关闭 否则无法写入
    }
}
