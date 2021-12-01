package com.tommychan.javaselearning.socket.TCPFilesCopy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings({"all"})
public class TCPFileCopyServer01 {
    public static void main(String[] args) throws IOException {
        //思路：
        //(1)在本机的8888端口监听 等待连接
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Server: 8888 waiting for connecting...");

        //(2)当没有客户端连接8888端口时 端口会阻塞不会继续运行 等待连接
        //   如果有客户端连接 则返回一个Socket对象
        Socket socket = serverSocket.accept();
        System.out.println("Client connected successfully");

        //(3)通过socket.getInputStream() 字节流读取图片 写入到src目录下
        InputStream inputStream = socket.getInputStream();
        String path = "src\\HarryPotter.jpg";
        FileOutputStream outputStream = new FileOutputStream(path,true);

        byte[] bf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(bf))!=-1){
            outputStream.write(bf,0,readLen);
        }
        System.out.println("Server : upload successfully");

        //(4)收到文件后发送"收到文件"到数据通道
        BufferedWriter bfr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bfr.write("Server has received file");
        bfr.flush(); //用字符流读取一定要刷新
        socket.shutdownOutput();

        //(5)关闭流 和 socket
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}
