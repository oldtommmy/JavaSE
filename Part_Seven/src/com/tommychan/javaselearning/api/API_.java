package com.tommychan.javaselearning.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author TommyChan
 * @version 1.0
 * description 演示 InetAddress的用法
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {

        //(1) 获取本机的InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        //(2)根据指定主机名获取InetAddress对象
        InetAddress localHost1 = InetAddress.getByName("TommyChan‘sPC");
        System.out.println(localHost1);

        //(3)根据域名获取InetAddress对象
        InetAddress localHost2 = InetAddress.getByName("www.baidu.com");
        System.out.println(localHost2);

        //(4)通过 InetAddress对象 获取对应的地址
        System.out.println("localHost的ip地址"+localHost.getHostAddress());//获取ip地址

        //(5)通过 InetAddress对象 获取对应的主机名或者域名
        System.out.println("myComputer主机名: "+localHost.getHostName());
        System.out.println("baidu域名: "+localHost2.getHostName());

    }
}
