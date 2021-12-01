package com.tommychan.clientService;

import com.tommychan.chatCommon.Message;
import com.tommychan.chatCommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @author TommyChan
 * @version 1.0
 * description 该类提供 发送消息等 方法
 */
public class ChatClientService {

    public ChatClientService() {

    }

    //私聊功能的实现
    public void sendMessageToOne(String fromID, String toID, String content){
        Message message = new Message();
        message.setSender(fromID);
        message.setReceiver(toID);
        message.setContent(content);
        message.setMessageType(MessageType.MESSAGE_COMMON_CHATWITHONE);
        message.setSendTime(new Date().toString());
        System.out.println("You said to "+"\""+toID+"\""+": "+content);

        //发送给服务端
        //先拿到客户端与服务端的线程
        //再拿到输出流
        try {
            ClientConnectServiceThread thread = ManageClientToServiceThread.getThread(fromID);
            ObjectOutputStream oos = new ObjectOutputStream(thread.getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //群发的实现
    public void sendMessageToEveryone(String ID, String content){
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_COMMON_CHATWITHEVERYONE);
        message.setContent(content);
        message.setSender(ID);

        //发送给服务端
        //先拿到客户端与服务端的线程
        //再拿到输出流
        try {
            ClientConnectServiceThread thread = ManageClientToServiceThread.getThread(ID);
            ObjectOutputStream oos = new ObjectOutputStream(thread.getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
