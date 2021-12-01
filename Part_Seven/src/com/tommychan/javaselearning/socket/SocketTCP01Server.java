package com.tommychan.javaselearning.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author TommyChan
 * @version 1.0
 * description 服务端
 */
@SuppressWarnings({"all"})
public class SocketTCP01Server {
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

        //(3)通过socket.getInputStream() 读取客户端写入到数据通道的数据
        InputStream inputStream = socket.getInputStream();

        //(4)通过IO读取
        byte[] bytes = new byte[1024];
        int readLen = 0;
        System.out.print("Recieving Message:");
        while ((readLen = inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,readLen));
        }

        //(5)获取输出流，回送消息到数据通道
        //   在写入结束后需要设置一个结束标记 表示写入结束 socket.shutdownOutput()
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello Client".getBytes());
        socket.shutdownOutput();

        //(5)关闭流和socket
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}
