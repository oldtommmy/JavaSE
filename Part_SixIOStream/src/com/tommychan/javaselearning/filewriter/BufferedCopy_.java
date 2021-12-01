package com.tommychan.javaselearning.filewriter;

import java.io.*;

/**
  * @author TommyChan
  * @version 1.0
  * description: 演示用包装流进行文件拷贝
  * BufferedReader 与 BufferedWriter 是按照字符操作
  * 不要去操作二进制文件 (声音 视频 等)
 */
public class BufferedCopy_ {
    public static void main(String[] args) throws IOException {

        String srcPath = "d:\\tempFiles\\test1.txt";
        String desPath = "d:\\tempFiles\\test2.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(srcPath));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(desPath));

        String line;
        //边读取边写入
        try {
            while ((line = bufferedReader.readLine())!=null){
                bufferedWriter.write(line);
                bufferedWriter.newLine();//写入一个换行
            }
            System.out.println("写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
                System.out.println("流已关闭");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
