package com.tommychan.javaselearning.exercise;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Exercise01TCPClient {
    public static void main(String[] args) throws IOException {

        //1.连接服务端 连接本机的7777端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 7777);

        //2.创建输出流 并转换为字符流
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(outputStream));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input your question: ");
        String question = scanner.next();

        //3.写入数据
        bfw.write(question);
        bfw.newLine();
        bfw.flush();

        //4.创建输入流
        InputStream inputStream = socket.getInputStream();
        BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream));
        String readLine = bfr.readLine();
        if (readLine!=null){
            System.out.println("Server: "+readLine);
        }


        //5.再次写入数据到数据通道
        System.out.print("Please input your question: ");
        question = scanner.next();
        bfw.write(question);
        bfw.newLine();
        bfw.flush();

        readLine = bfr.readLine();
        if (readLine!=null){
            System.out.println("Server: "+readLine);
        }

        //6.释放资源
        bfr.close();
        bfw.close();

    }
}
