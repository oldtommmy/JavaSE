package com.tommychan.javaselearning.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //1.创建一个DatagramSocket对象
        //  并指定端口 9999 接收数据
        DatagramSocket socket = new DatagramSocket(9999);
        //2.构建一个 DatagramPacket 对象 准备接收数据
        //  一个数据包最大 64K
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        //3.调用方法 将通过网络传输的DatagramPacket 对象
        //  填充到 packet 对象
        //  当有数据包发送到9999端口 就会收到数据
        //  如果没有数据包发送到本机的 9999 端口 就会阻塞等待
        System.out.println("Receiver is waiting for connection...");
        socket.receive(packet);
        System.out.println("Receiver is connected");

        //4.可以把packet进行拆包 取出数据 并显示
        int length = packet.getLength();//实际接受长度
        byte[] bytes = packet.getData();//接收到的数据

        String s = new String(bytes, 0 ,length);
        System.out.println("Receive info: "+ s);

        //5.创建DatagramPacket 发送信息
        byte[] data = "OK I got it".getBytes();
        DatagramPacket packet1 = new DatagramPacket(data, 0, data.length, InetAddress.getByName("172.20.10.3"), 9998);

        //6.发送packet1
        socket.send(packet1);

        //7.关闭资源
        socket.close();
    }
}
