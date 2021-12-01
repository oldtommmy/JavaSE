package com.tommychan.javaselearning.exercise;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Exercise01TCPServer {
    public static void main(String[] args) throws IOException {
        //1.连接客户端
        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("Server is waiting for connection");

        //2.若连接成功 则返回一个Socket对象
        Socket socket = serverSocket.accept();

        //3.得到一个输入流
        InputStream inputStream = socket.getInputStream();
        BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream));

        //4.创建一个输出流
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(outputStream));

        //5.从数据通道获取数据
        String readLine = bfr.readLine();
        System.out.println("Client: "+readLine);
        String answer;
        if (readLine.equals("name?")){
            answer = "Tommy";
        }else{
            answer = "what?";
        }
        bfw.write(answer);
        bfw.newLine();
        bfw.flush();

        readLine = bfr.readLine();
        System.out.println("Client: "+readLine);
        if (readLine.equals("hobby?")){
            answer = "watch bilibili";
        }else{
            answer = "what?";
        }
        bfw.write(answer);
        bfw.newLine();
        bfw.flush();

        //6.关闭资源
        bfr.close();
        bfr.close();

    }
}
