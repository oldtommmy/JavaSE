package com.tommychan.chatServer.service;

import com.tommychan.chatCommon.Message;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class ManageOfflineMessage {
    private static ConcurrentHashMap<String, ArrayList<Message>> hm= new ConcurrentHashMap<>();

    //添加消息到集合中
    public static void addMessages(String ID,Message message){
        //如果集合已经存在该用户的消息列表
        if (offlineMessageExist(ID)){
            hm.get(ID).add(message);
        } else { //不存在
            ArrayList<Message> messages = new ArrayList<>();
            messages.add(message);
            hm.put(ID,messages);
        }
    }

    //提供一个检索某ID是否存在离线消息的方法
    public static boolean offlineMessageExist(String ID){
        ConcurrentHashMap.KeySetView<String, ArrayList<Message>> ids = hm.keySet();
        for(Object o:ids){
            String id = (String) o;
            if (id.equals(ID)){
                return true;
            }
        }
        return false;
    }

    //返回某个ID收到的离线Message的List
    public static ArrayList<Message> getOfflineMes(String ID){
        return hm.get(ID);
    }

    //删除某个ID的MessageList
    public static void removeOffMes(String ID){
        hm.remove(ID);
    }
}
