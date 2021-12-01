package com.tommychan.javaselearning.exercise;

import java.io.IOException;
import java.net.*;

public class Exercise02UDPSender {
    public static void main(String[] args) throws IOException {
        //1.创建一个DatagramSocket对象 指定对应的7777端口
        //  此处是在同一台机器上，故使用不同的port，如果是两台不同的机器，则可以使用相同的port
        DatagramSocket socket = new DatagramSocket(7777);

        //2.DatagramPacket(byte[],int,int,InetAddress,int)
        //                 数据   开始  结束    主机    端口
        byte[] data = "the four great classic Chinese novels".getBytes();
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, InetAddress.getByName("10.15.8.69"), 7778);

        //3.调用DatagramSocket的send方法 将packet发送
        socket.send(packet);

        //4.接收Receiver发的packet1 拆包和输出
        socket.receive(packet);

        int length = packet.getLength();
        data = packet.getData();
        System.out.println("Receiver: "+new String(data, 0, length));

        //5.关闭资源
        socket.close();
    }
}
