package com.tommychan.chatServer.service;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.tommychan.chatCommon.Message;
import com.tommychan.chatCommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author TommyChan
 * @version 1.0
 * description 该类对应的对象和某个客户端保持通信 即维持一个线程
 */
@SuppressWarnings({"all"})
public class ServerConnectClientThread extends Thread{

    private Socket socket;
    private String ID;//连接服务端的用户ID

    public ServerConnectClientThread(Socket socket, String ID) {
        this.socket = socket;
        this.ID = ID;
    }

    @Override
    public void run() {

        //持续读取来自于客户端的信息 并回复消息
        while (true){

            try {
                System.out.println("Server is keeping communicating with Client \""+ID+"\"...");
                System.out.println("======================================");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

                Message message = (Message) ois.readObject();
                //根据信息内容进行不同业务操作
                //注意不要把输出流写在if判断外面 会出现StreamCorruptedException的报错
                //

                //客户端请求返回在线列表时
                if (message.getMessageType().equals(MessageType.MESSAGE_GET_ONLINELIST)){

                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    System.out.println("\""+message.getSender()+"\" applies for the online user list");
                    System.out.println("======================================");
                    String onlineUsers = ManageServerToClientThread.getOnlineUsers();
                    //构建一个Message返回给客户端
                    Message message1 = new Message();
                    message1.setMessageType(MessageType.MESSAGE_RETURN_ONLINELIST);
                    message1.setContent(onlineUsers);
                    message1.setReceiver(message.getSender());
                    oos.writeObject(message1);

                } else if (message.getMessageType().equals(MessageType.MESSAGE_CLIENT_EXIT)){
                    //客户端用户请求下线
                    //关闭该客户端用户与服务端之间的线程所持有的Socket
                    socket.close();
                    //从集合中移除该客户端用户与服务端之间的线程
                    ManageServerToClientThread.removeThread(message.getSender());
                    //退出线程
                    System.out.println("\""+message.getSender()+"\" has logged out");
                    System.out.println("======================================");
                    break;

                } else if(message.getMessageType().equals(MessageType.MESSAGE_COMMON_CHATWITHONE)){

                    /** 离线留言功能
                      * 1. 用一个ConcurrentHashMap<String, ArrayList<Message>>来存放离线的消息
                      * 2. 服务器接收消息时，若接收用户不在线，则存入集合中，因此需要一个方法判断是否接收用户在线
                      * 3. 在每个用户登陆时，都去离线消息库中检测是否有发送给该用户的消息
                     */

                    //信息接收者不在线
                    if (!ManageServerToClientThread.isOnline(message.getReceiver())){

                        ManageOfflineMessage.addMessages(message.getReceiver(),message);
                        System.out.println("\""+message.getSender()+"\" sent offine message to "+message.getReceiver());

                    } else { //在线时
                        //客户端请求与某个在线用户私聊
                        System.out.println("\""+message.getSender()+"\" said to "+message.getReceiver());
                        //找到服务端与目标用户的线程 将消息转发
                        //直接拿到输出流
                        ObjectOutputStream oos1 =
                                new ObjectOutputStream(ManageServerToClientThread.getStCThread(message.getReceiver())
                                        .socket.getOutputStream());
                        oos1.writeObject(message);
                    }

                } else if (message.getMessageType().equals(MessageType.MESSAGE_COMMON_CHATWITHEVERYONE)){

                    //客户端请求群发消息
                    System.out.println("\""+message.getSender()+"\" said to everyone");
                    //遍历保存了线程的HashMap服务端与客户端的每个线程
                    //分别发送信息包
                    Set keySet = ManageServerToClientThread.getKeySet();
                    for(Object o:keySet){
                        String ID = (String) o;
                        ObjectOutputStream oos =
                                new ObjectOutputStream(ManageServerToClientThread.getStCThread(ID).
                                        socket.getOutputStream());
                        oos.writeObject(message);
                    }

                } else if (message.getMessageType().equals(MessageType.MESSAGE_SEND_FILE)) {

                    //客户端发送文件给其他用户
                    System.out.println("\"" + message.getSender() + "\" is sending files to " +
                            "\"" + message.getReceiver() + "\"");
                    //转发该文件
                    ObjectOutputStream oos
                            = new ObjectOutputStream(ManageServerToClientThread.getStCThread(message.getReceiver()).
                                    socket.getOutputStream());
                    oos.writeObject(message);
                }
                else{
                    System.out.println("其他功能暂时不开放");
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}
