package com.tommychan.clientService;

import com.tommychan.chatCommon.Message;
import com.tommychan.chatCommon.MessageType;
import com.tommychan.chatCommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author TommyChan
 * @version 1.0
 * description  用于用户注册和登录等功能
 */
public class UserClientService {

    private User user = new User(); //将User做成属性 方便以后调用User的各项信息
    private Socket socket;//将Socket做成属性 因为在其他地方也会使用

    public UserClientService() {

    }

    //检测登陆时密码的正确性
    public boolean checkUser(String ID, String PWD) throws IOException, ClassNotFoundException {

        Boolean flag = false;
        user.setId(ID);
        user.setPwd(PWD); //设置user的id和pwd

        //创建一个Socket 用于和服务端进行连接
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),7777);//服务器在7777端口监听
        } catch (IOException e) {
            e.printStackTrace();
        }

        //将user发送给服务端进行验证
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(user);

        //从服务端获取Message对象
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Message message = (Message) ois.readObject(); //readObject返回的是Object类型 所以需要转型

        //对Message进行判断
        if (message.getMessageType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){//登陆成功

            //创建一个和服务器端保持通信的线程 -> 需要创建一个类来实现 ClientConnectServiceThread
            ClientConnectServiceThread ccsThread = new ClientConnectServiceThread(socket);
            //启动线程
            ccsThread.start();
            //为了客户端的拓展 我们将线程放入一个集合管理
            ManageClientToServiceThread.addThread(ID,ccsThread);
            flag = true;

        } else { //登录失败 则不能启动和服务器通信的线程
            socket.close(); //关闭Socket即可
        }
        return flag;
    }

    public void onlineFriend(String ID){ //向服务器传送拉取在线用户的信息
        Message message = new Message();
        message.setSender(ID);
        message.setMessageType(MessageType.MESSAGE_GET_ONELINERS);

        //需要得到该用户与服务端之间线程的一个输出流
        try {
            ClientConnectServiceThread ccsThread = ManageClientToServiceThread.getThread(user.getId());
            ObjectOutputStream oos = new ObjectOutputStream(ccsThread.getSocket().getOutputStream());
            oos.writeObject(message);

        } catch (IOException e) {

        }
    }

    //退出客户端 向服务器发送退出系统的Message对象
    public void LogOut(String ID){
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(ID); //一定要指明客户端的用户名
        //发送message
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientToServiceThread.getThread(ID).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println("You have logged out , see you next time!");
            System.exit(0);//结束进程
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
