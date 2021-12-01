package com.tommychan.javaselearning.filewriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
  * @author TommyChan
  * @version 1.0
  * description:演示 BufferedWriter 的使用
 */
public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {

        String path = "d:\\tempFiles\\test3.txt";

        //创建一个 BufferedWriter
        //写了true则是追加写入 不加就是覆盖写入
        //写在节点流中
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));

        for (int i = 0; i < 10; i++) {
            bufferedWriter.write("fuck this world");
        }

        bufferedWriter.close();
        //关闭包装流即可 传入的 new FileWriter(path) 会在底层关闭

    }
}
