package com.tommychan.chatServer.service;


import com.tommychan.chatCommon.Message;
import com.tommychan.chatCommon.MessageType;
import com.tommychan.chatCommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * @author TommyChan
 * @version 1.0
 * description 服务器 监听 7777 端口 等待客户端连接，并保持通信
 */
public class ChatServer {

    private ServerSocket serverSocket;
    private static HashMap<String, User> validUser= new HashMap<>();//用来存放多个用户
    //HashMap没有处理线程安全 因此在多线程下是不安全的
    //ConcurrentHashMap 处理的线程安全即线程同步处理，在多数线程情况下是安全的
    //private static ConcurrentHashMap<String, User> validUser= new ConcurrentHashMap<>();

    static {
        validUser.put("Tommy",new User("Tommy","123456"));
        validUser.put("Henry",new User("Henry","1234567"));
        validUser.put("Charlie",new User("Charlie","12345678"));
    }

    public static void main(String[] args) throws ClassNotFoundException {
        new ChatServer();
    }

    public boolean checkUser(String ID,String PWD){
        User user = validUser.get(ID);
        if (user == null){ //说明该用户不在库中
            System.out.println("\""+ID+"\" doesn't exist in DataBase......");
            return false;
        }
        if (!user.getPwd().equals(PWD)){ //在库中 但密码错误
            System.out.println("\""+ID+"\"s password is not correct");
            return false;
        }
        return true;
    }

    public ChatServer() throws ClassNotFoundException {

        //创建Socket
        try {
            System.out.println("Server port 7777 is listening...");
            System.out.println("================================");
            serverSocket = new ServerSocket(7777);

            while (true){ //监听是循环的 和某个客户端建立连接后继续监听
                Socket socket = serverSocket.accept();

                //通过accept接收User对象
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                User user = (User) ois.readObject();

                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                //回送至客户端的信息
                Message message = new Message();

                //验证登陆成功后的操作
                if (checkUser(user.getId(), user.getPwd())){
                    //验证通过 返回“登录成功”的信息
                    message.setMessageType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    oos.writeObject(message);

                    //创建一个线程与客户端保持通讯 -> 用一个ServerConnectClientThread来实现
                    ServerConnectClientThread sccThread = new ServerConnectClientThread(socket, user.getId());
                    //启动该线程
                    sccThread.start();
                    //将该线程加入一个集合进行管理
                    ManageServerToClientThread.addClientThread(user.getId(), sccThread);

                    Thread.sleep(1000);
                    //检测是否收到离线消息
                    if (ManageOfflineMessage.offlineMessageExist(user.getId())){

                        //存在离线信息 返回一个"存在离线信息"的信息包
                        ObjectOutputStream oos1 =
                                new ObjectOutputStream(socket.getOutputStream());
                        Message messageOffMes = new Message();
                        messageOffMes.setMessageType(MessageType.MESSAGE_RECEIVE_OFFLINEMES);
                        messageOffMes.setOffLineMes(ManageOfflineMessage.getOfflineMes(user.getId()));
                        oos1.writeObject(messageOffMes);
                        ManageOfflineMessage.removeOffMes(user.getId());
                    }

                } else { //登录失败
                    System.out.println("\""+user.getId()+"\" failed to login");
                    System.out.println("================================");
                    message.setMessageType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    socket.close();
                }

            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            //如果退出了循环 这说明服务器不在监听 因此关闭serverSocket
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
