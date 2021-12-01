package com.tommychan.chatCommon;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author TommyChan
 * @version 1.0
 * description 表示客户端和服务端的一个传输的信息对象
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    private String sender;
    private String receiver;
    private String content;
    private String sendTime;
    private String messageType;

    //用于发送文件时的属性
    private byte[] fileBytes;
    private int fileLen = 0;
    private String destPath;
    private String srcPath;

    //离线消息List
    private ArrayList<Message> offLineMes;

    public ArrayList<Message> getOffLineMes() {
        return offLineMes;
    }

    public void setOffLineMes(ArrayList<Message> offLineMes) {
        this.offLineMes = offLineMes;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
