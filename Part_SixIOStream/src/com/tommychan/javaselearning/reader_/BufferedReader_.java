package com.tommychan.javaselearning.reader_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
  * @author TommyChan
  * @version 1.0
  * description: 使用 BufferedReader 读取文本文件
 */
public class BufferedReader_ {
    public static void main(String[] args) throws IOException {

        String path = "d:\\tempFiles\\test1.txt";
        //创建 BufferedReader 对象
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        //读取 使用readLine()读取 返回一个String
        //    如果读取结束返回null
        String line;

        while ((line = bufferedReader.readLine())!=null) {
            System.out.println(line);
        }

        bufferedReader.close();
        //我们只需关闭BufferedReader 因为底层会自动关闭节点流
    }
}

