package com.tommychan.chatCommon;

/**
 * @author TommyChan
 * @version 1.0
 * description 用于表示消息类型
 */
public interface MessageType {
    String MESSAGE_LOGIN_SUCCEED = "1"; //登陆成功
    String MESSAGE_LOGIN_FAIL = "2"; //登录失败
    String MESSAGE_COMMON_CHATWITHONE = "3"; //普通信息包 即 私聊发送消息
    String MESSAGE_GET_ONELINERS = "4"; //要求返回在线用户列表
    String MESSAGE_RETURN_ONLINELIST = "5"; //返回在线用户列表
    String MESSAGE_CLIENT_EXIT = "6"; //客户端请求退出
    String MESSAGE_COMMON_CHATWITHEVERYONE = "7"; //普通信息包---群聊
    String MESSAGE_SEND_FILE = "8"; //发送文件
    String MESSAGE_RECEIVE_OFFLINEMES = "9"; //收到离线消息
}
