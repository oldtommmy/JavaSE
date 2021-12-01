package com.tommychan.clientMenu;

import com.tommychan.clientService.ChatClientService;
import com.tommychan.clientService.FileClientService;
import com.tommychan.clientService.UserClientService;
import com.tommychan.utils.Utility;

import java.io.IOException;

public class ShowMenu {

    private boolean loop = true; //控制菜单的显示
    private String key = ""; //接收用户的选择输入
    private UserClientService userClientService = new UserClientService();//用于注册登录等等用户服务
    private ChatClientService chatClientService = new ChatClientService();//用于发送消息等服务
    private FileClientService fileClientService = new FileClientService();//用于发送文件服务

    public static void main(String[] args) throws Exception {
        new ShowMenu().mainMenu();
    }
    private void mainMenu() throws Exception {

        while (loop){
            System.out.println("==========Chat Client==========");
            System.out.println("\t\t1. Login ");
            System.out.println("\t\t9. Exit");
            System.out.println("===============================");

            System.out.print("Please input your choice: ");
            key = Utility.readString(1);

            switch (key){
                case "1":
                    System.out.println("==========Login System=========");
                    System.out.print("ID: ");
                    String ID = Utility.readString(10);
                    System.out.print("Password: ");
                    String PWD = Utility.readString(25);

                    //到服务器进行验证
                    if (userClientService.checkUser(ID,PWD)){ //如果正确 进入二级菜单
                        System.out.println("============Welcome "+ID+"==========");

                        while (loop){
                            System.out.println("\t\t1. Online Users List");
                            System.out.println("\t\t2. Chat with Friend");
                            System.out.println("\t\t3. Mass Mailing");
                            System.out.println("\t\t4. Send Files");
                            System.out.println("\t\t5. Exit");
                            System.out.println("=================================");
                            System.out.print("Please choose from the Menu: ");
                            key = Utility.readString(1);
                            switch (key){
                                case "1":
                                    userClientService.onlineFriend(ID);
                                    break;
                                case "2":
                                    System.out.print("Please input ID of your friend who you want to chat: ");
                                    String chatToID = Utility.readString(20);
                                    System.out.print("Input Your Message(less than 50 letters): ");
                                    String content = Utility.readString(50);
                                    chatClientService.sendMessageToOne(ID, chatToID, content);
                                    System.out.println("=================================");
                                    break;
                                case "3":
                                    System.out.print("Input Your Message(less than 50 letters): ");
                                    String content1 = Utility.readString(50);
                                    chatClientService.sendMessageToEveryone(ID, content1);
                                    System.out.println("=================================");
                                    break;
                                case "4":
                                    System.out.print("Please input ID which you wanna send file to:");
                                    String fileToID = Utility.readString(20);
                                    System.out.println("Please input path of the source file:");
                                    String srcPath = Utility.readString(40);
                                    System.out.println("Please input path of the source file:");
                                    String destPath = Utility.readString(40);
                                    fileClientService.sendFiles(ID, fileToID, srcPath, destPath);
                                    System.out.println("=================================");
                                    break;
                                case "5":
                                    //调用方法 无异常退出系统
                                    userClientService.LogOut(ID);
                                    loop = false;
                                    break;
                            }
                        }
                    }else{ //登录失败
                        System.out.println("Password or ID is not correct...");
                    }
                    break;
                case "9":
                    loop = false;
                    System.out.println("Client has exited");
                    break;
            }
        }

    }
}
