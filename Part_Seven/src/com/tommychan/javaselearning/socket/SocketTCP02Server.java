package com.tommychan.javaselearning.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author TommyChan
 * @version 2.0
 * description 服务端
 */
@SuppressWarnings({"all"})
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        //思路：
        //(1)在本机的9999端口监听 等待连接
        //   要求本机没有其他服务监听9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server: 9999 waiting for connecting...");

        //(2)当没有客户端连接9999端口时 端口会阻塞不会继续运行 等待连接
        //   如果有客户端连接 则返回一个Socket对象
        Socket socket = serverSocket.accept();
        System.out.println("Server: Client connected");

        //(3)通过socket.getInputStream()
        //   转换流 转为 字符流
        //   读取客户端写入到数据通道的数据
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        //(4)通过IO读取
        System.out.print("Recieving Message:");
        String readLine = "";
        while ((readLine = reader.readLine())!=null){
            System.out.println(readLine);
        }

        //(5)获取输出流，回送消息到数据通道
        //   在写入结束后需要设置一个结束标记 表示写入结束 writer.newLine();
        //   注意 用writer.newLine();时 另一端读取需要使用readLine()
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        writer.write("Hello Client");
        writer.newLine();
        writer.flush();

        //(5)关闭流和socket

        reader.close();
        socket.close();
        serverSocket.close();
    }
}
