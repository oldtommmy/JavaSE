package com.tommychan.chatFrame;

import com.tommychan.chatServer.service.ChatServer;

/**
 * @author TommyChan
 * @version 1.0
 * description 该类创建 ChatServer, 启动后台服务
 */
public class ChatFrame {
    public static void main(String[] args) throws ClassNotFoundException {
        new ChatServer();
    }
}
