package com.tommychan.clientService;

import com.tommychan.chatCommon.Message;
import com.tommychan.chatCommon.MessageType;


import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author TommyChan
 * @version 1.0
 * description 用于维护 User 与 服务端的线程类
 */
public class ClientConnectServiceThread extends Thread {
    //该线程需要持有Socket
    private Socket socket;

    public ClientConnectServiceThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() { //线程需要在后台和服务器通信

        while (true){ //需要读取服务器回送的消息

            try {
                System.out.println("Waiting for the information from Server...");
                //如果数据通道没有数据 线程则会阻塞在readObject()方法处
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();

                //接收服务端的信息包
                //返回一个在线用户列表
                if (message.getMessageType().equals(MessageType.MESSAGE_RETURN_ONLINELIST)){
                    //取出在线用户列表
                    //规定：返回列表每个用户信息以空格分割
                    String[] onlineUsers = message.getContent().split(" ");
                    System.out.println("==========Online Friends=========");
                    for (int i = 0; i < onlineUsers.length; i++) {
                        System.out.println("User: "+onlineUsers[i]);
                    }
                    System.out.println("==================================");
                } else if (message.getMessageType().equals(MessageType.MESSAGE_COMMON_CHATWITHONE)){

                    //即收到了服务器转发的来自某个用户的消息
                    //输出消息
                    System.out.println("==================================");
                    System.out.println("\""+message.getSender()+"\" : ");
                    System.out.println("[ "+message.getContent()+" ]");
                    System.out.println("==================================");
                } else if (message.getMessageType().equals(MessageType.MESSAGE_COMMON_CHATWITHEVERYONE)){

                    //即收到了群发消息
                    System.out.println("==================================");
                    System.out.println("\""+message.getSender()+"\" said to everyone: ");
                    System.out.println("[ "+message.getContent()+" ]");
                    System.out.println("==================================");
                } else if (message.getMessageType().equals(MessageType.MESSAGE_SEND_FILE)){

                    //收到了文件传输
                    FileClientService fileClientService = new FileClientService();
                    fileClientService.receiveFile(message);
                    System.out.println("You have received files from "+"\""+message.getSender()+"\"");
                    System.out.println("==================================");
                    System.out.println("You have received files from "+"\""+message.getSender()+"\"");
                    System.out.println("Files has been stored in "+message.getDestPath());
                    System.out.println("==================================");

                } else if (message.getMessageType().equals(MessageType.MESSAGE_RECEIVE_OFFLINEMES)){

                    //存在离线消息
                    ArrayList<Message> offLineMes = message.getOffLineMes();
                    System.out.println("You received some off line messages:");
                    for(Object o:offLineMes){
                        Message offMes = (Message) o;
                        System.out.println("\""+offMes.getSender()+"\" :");
                        System.out.println("[ "+offMes.getContent()+" ]");
                    }

                }
                else {
                    System.out.println("其他业务暂时未开通");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }

    //为了更方便得到 Socket
    public Socket getSocket() {
        return socket;
    }

}
