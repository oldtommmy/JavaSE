package com.tommychan.javaselearning.exercise;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Exercise02UDPReceiver {
    public static void main(String[] args) throws IOException {
        //1.创建一个DatagramSocket对象
        DatagramSocket socket = new DatagramSocket(7778);

        //2.创建一个DatagramPacket对象
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        //3.调用方法 将通过网络传输的DatagramPacket 对象
        //  填充到 packet 对象
        //  当有数据包发送到9999端口 就会收到数据
        //  如果没有数据包发送到本机的 9999 端口 就会阻塞等待
        System.out.println("Receiver is waiting for connection...");
        socket.receive(packet);
        System.out.println("Connected!");

        //4.可以把packet进行拆包 取出数据 并显示
        int length = packet.getLength();//实际接受长度
        byte[] bytes = packet.getData();//接收到的数据
        System.out.println("Sender: "+new String(bytes, 0, length));

        //5.创建DatagramPacket 发送信息
        byte[] data = ("Romance of the Three Kingdoms,Outlaws of the Marsh," +
                "Journey to the West,A Dream of Red Mansions)").getBytes();
        DatagramPacket packet1 = new DatagramPacket(data, 0, data.length, InetAddress.getByName("10.15.8.69"), 7777);
        socket.send(packet1);

        //6.关闭资源
        socket.close();
    }
}
