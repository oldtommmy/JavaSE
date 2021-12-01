package com.tommychan.javaselearning.printstream;

import java.io.IOException;
import java.io.PrintStream;

/**
  * @author TommyChan
  * @version 1.0
  * description: 演示 PrintStream (字节打印流 )
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {

        PrintStream out = System.out;
        out.println("hello world"); //默认输出位置是 标准输出 即在显示器输出
                            //底层调用的是 write()方法
        out.write("hello world".getBytes()); //故也可以直接调用write()方法
        out.close();

        //也可以修改打印流输出的位置，设备
        System.setOut(new PrintStream("d:\\tempFiles\\test1.txt"));
        System.out.println("hello world");//输入，写入到d:\\tempFiles\\test1.txt
    }
}
