package com.tommychan.javaselearning.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSenderB {
    public static void main(String[] args) throws IOException {

        //1.创建一个DatagramSocket对象 指定对应的9998端口
        //  此处是在同一台机器上，故使用不同的port，如果是两台不同的机器，则可以使用相同的port
        DatagramSocket socket = new DatagramSocket(9998);

        //2.DatagramPacket(byte[],int,int,InetAddress,int)
        //                 数据   开始  结束    主机    端口
        byte[] data = "hello let's go to eat hot pot".getBytes();
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, InetAddress.getByName("172.20.10.3"),9999);

        //3.调用方法 将packet发送
        socket.send(packet);
        System.out.println("Sender has sent info successfully");

        //4.接收Receiver发的packet1
        socket.receive(packet);

        //5.拆包和输出
        int length = packet.getLength();
        byte[] data1 = packet.getData();
        System.out.println("Receive info: "+new String(data1,0,length));

        //6.关闭资源
        socket.close();

    }
}
