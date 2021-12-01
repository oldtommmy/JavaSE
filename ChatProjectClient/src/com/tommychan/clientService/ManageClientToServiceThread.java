package com.tommychan.clientService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author TommyChan
 * @version 1.0
 * description 用于管理客户端与服务端之间的线程的一个类
 */
public class ManageClientToServiceThread {

    //我们将多个线程存入HashMap key为用户的ID value为线程
    private static HashMap<String,ClientConnectServiceThread> hm = new HashMap<>();

    //将某个线程加入到集合
    public static void addThread(String ID, ClientConnectServiceThread ccst){
        hm.put(ID, ccst);
    }

    //通过ID 得到该用户的线程
    public static ClientConnectServiceThread getThread(String ID){
        return hm.get(ID);
    }

    //通过线程得到ID
//    public static String getIdOfThread(ClientConnectServiceThread ccst){
//        Set entrySet = hm.entrySet();
//        for (Object o:entrySet) {
//            //o 运行的类型是HashMap$Node
//            //我们将它转为Map.Entry才可以使用getKey() getValue()
//            Map.Entry entry = (Map.Entry) o;
//            if (entry.getValue()==ccst){
//                return (String) entry.getKey();
//            }
//        }
//        return null;
//    }
}
