package com.tommychan.javaselearning.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author TommyChan
 * @version 2.0
 * description  客户端 发送 "Hello Server"给 服务端
 */
@SuppressWarnings({"all"})
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        //思路：
        //(1)连接服务端 (ip,端口)
        //   连接本机的9999端口 如果连接成功 则返回一个Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("Client: connected socket:"+socket.getClass());

        //(2)连接上后 生成Socket 通过socket.getOutputStream()
        //   得到和 socket 对象关联的输出对象
        //   再用转换流将字节流转换为字符流
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        //(3)通过输出流 写入数据到 数据通道
        //在写入结束后需要设置一个结束标记 表示写入结束 socket.shutdownOutput()
        //否则另一端会继续阻塞在这一步(因为不知道是否还有数据要读取)
        writer.write("Hello Server");
        writer.newLine();
        writer.flush();
        socket.shutdownOutput();

        //(4)获取和socket关联的输入流 并从数据通道读取数据
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        System.out.print("Recieving Message:");
        String readLine = "";
        while ((readLine = reader.readLine())!=null){
            System.out.println(readLine);
        }

        //(5)关闭流对象 和 socket

        reader.close();
        socket.close();
    }
}
