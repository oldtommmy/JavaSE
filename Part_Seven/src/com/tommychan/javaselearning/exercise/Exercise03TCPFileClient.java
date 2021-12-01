package com.tommychan.javaselearning.exercise;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

@SuppressWarnings({"all"})
public class Exercise03TCPFileClient {
    public static void main(String[] args) throws IOException {

        //1.创建一个Socket对象
        Socket socket = new Socket(InetAddress.getByName("10.15.8.69"),7777);

        //2.创建输出流 数据通道中写入文件
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(outputStream));//字符流写入路径
        System.out.println("Client has connected with Server");

        bfw.write("d:\\tempFiles\\ddd.mp3");
        bfw.flush();
        socket.shutdownOutput();

        //3.创建输入流 数据通道中读取数据
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\tempFiles\\newSong.mp3");

        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf, 0, buf.length))!=-1){
            fileOutputStream.write(buf,0,readLen);
        }
        fileOutputStream.close();
        inputStream.close();

        //4.关闭资源
        socket.close();
    }
}
