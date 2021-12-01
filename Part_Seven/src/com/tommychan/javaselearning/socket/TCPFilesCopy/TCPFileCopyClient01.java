package com.tommychan.javaselearning.socket.TCPFilesCopy;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

@SuppressWarnings({"all"})
public class TCPFileCopyClient01 {
    public static void main(String[] args) throws IOException {
        //思路：
        //(1)连接服务端 (ip,端口)
        //   连接本机的8888端口 如果连接成功 则返回一个Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(),8888);
        System.out.println("Client: Connected with server");

        //(2)连接上后 生成Socket 通过socket.getOutputStream()
        //   FileInputStreamReader 读入指定图片文件
        OutputStream outputStream = socket.getOutputStream();
        String picPath = "d:\\tempFiles\\HarryPotter.jpg";
        FileInputStream inputStream = new FileInputStream(picPath);
        BufferedReader bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //(3)通过输入，输出流 边读取边写入指定图片数据到 数据通道
        byte[] bf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(bf))!=-1){
            outputStream.write(bf,0,readLen);
        }
        System.out.println("Client : upload successfully");
        socket.shutdownOutput();

        //(4)从数据通道里读取信息
        String readLine = "";
        while ((readLine = bfr.readLine())!=null){
            System.out.println(readLine);
        }

        //(5)关闭流对象 和 socket
        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
