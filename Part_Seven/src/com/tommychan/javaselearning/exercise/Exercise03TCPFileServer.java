package com.tommychan.javaselearning.exercise;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings({"all"})
public class Exercise03TCPFileServer {
    public static void main(String[] args) throws IOException {

        //1.创建一个ServerSocket对象 指定监听端口
        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("Server 7777 port is waiting for connection...");

        //2.连接成功则返回一个socket对象
        Socket socket = serverSocket.accept();
        System.out.println("Server 7777 port has connected...");

        //3.读取客户端想要下载的文件名
        InputStream inputStream = socket.getInputStream(); //得到一个字节流
        String filePath = "";
        int len = 0;
        byte[] buf0 = new byte[1024];
        while ((len = inputStream.read(buf0, 0, buf0.length))!=-1){
            filePath += new String(buf0, 0, len);
        }
        System.out.println("Server has recieved name of the file : "+ filePath);

        //4.有该文件则 先创建一个输入流边读取该文件 边写入数据通道
        //  否则返回一个默认文件
        OutputStream outputStream = socket.getOutputStream();//输出流
        if (new File(filePath).exists()){
            FileInputStream fileInputStream = new FileInputStream(filePath);
            byte[] buf = new byte[1024];
            int readLen = 0;
            while ((readLen = fileInputStream.read(buf))!=-1){
                outputStream.write(buf, 0, buf.length);
            }
            outputStream.close();
            fileInputStream.close();
            socket.shutdownOutput();
        }else{
            FileInputStream fileInputStream = new FileInputStream("d:\\tempFiles\\noFile.txt");
            byte[] buf = new byte[1024];
            int readLen = 0;
            while ((readLen = fileInputStream.read(buf))!=-1){
                outputStream.write(buf, 0, buf.length);
            }
            outputStream.close();
            fileInputStream.close();
            socket.shutdownOutput();
        }

        //5.关闭socket
        socket.close();
        serverSocket.close();

    }
}
