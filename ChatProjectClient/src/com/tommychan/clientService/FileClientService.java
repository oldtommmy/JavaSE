package com.tommychan.clientService;

import com.tommychan.chatCommon.Message;
import com.tommychan.chatCommon.MessageType;
import com.tommychan.utils.StreamUtils;

import java.io.*;

/**
  * @author TommyChan
  * @version 1.0
  * description: 该类用于实现文件传输
 */
@SuppressWarnings({"all"})
public class FileClientService {

    public FileClientService() {

    }

    public void sendFiles(String fromID, String toID, String srcPath, String destPath) throws Exception {
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_SEND_FILE);
        message.setSender(fromID);
        message.setReceiver(toID);
        message.setDestPath(destPath);

        //从客户端本地读取文件
        /**
         * 此处用到了工具类StreamUtils中的一个将文件转换成字节数组的一个方法 此方法的实现值得学习
         * */
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(srcPath);
            byte[] buff = StreamUtils.streamToByteArray(fileInputStream);
            message.setFileBytes(buff);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream!=null){
                fileInputStream.close();
            }
        }

        //写入文件到客户端与服务端的数据通道
        ObjectOutputStream oos =
                new ObjectOutputStream(ManageClientToServiceThread.getThread(fromID).getSocket().getOutputStream());
        oos.writeObject(message);
        System.out.println("You sent file to "+"\""+toID+"\"");
    }

    //读取文件
    public void receiveFile(Message message) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(message.getDestPath());
        fileOutputStream.write(message.getFileBytes());
        fileOutputStream.close();
    }
}
