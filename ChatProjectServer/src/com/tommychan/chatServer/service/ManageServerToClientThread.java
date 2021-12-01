package com.tommychan.chatServer.service;

import java.util.HashMap;
import java.util.Set;

/**
 * @author TommyChan
 * @version 1.0
 * description 用于管理客户端与服务端连接的线程
 */
public class ManageServerToClientThread {

    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    //用于添加线程到表中
    public static void addClientThread(String ID,ServerConnectClientThread thread){
        hm.put(ID, thread);
    }

    //get一个对应ID的线程
    public static ServerConnectClientThread getStCThread(String ID){
        return hm.get(ID);
    }

    //返回在线用户的一个字符串 每个用户间用空格分开 方便取出时spilt来分隔
    public static String getOnlineUsers(){
        //集合遍历
        Set<String> strings = hm.keySet();
        String onlineList = "";
        for (Object o:strings){
            onlineList += o.toString()+" ";
        }
        return onlineList;
    }

    //判断某用户是否在线
    public static boolean isOnline(String ID){
        Set<String> ids = hm.keySet();
        for(Object o:ids){
            String id = (String) o;
            if (id.equals(ID)){
                return true;
            }
        }
        return false;
    }

    //将指定的一个线程从集合中移除
    public static void removeThread(String ID){
        hm.remove(ID);
    }

    //返回一个keySet
    public static Set<String> getKeySet(){
        return hm.keySet();
    }

}
