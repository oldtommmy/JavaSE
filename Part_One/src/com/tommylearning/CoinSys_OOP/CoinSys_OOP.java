package com.tommylearning.CoinSys_OOP;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CoinSys_OOP {
        //1.各个属性
        boolean loop = true; //用于判断是否结束程序
        String key = "";
        Scanner scanner = new Scanner(System.in);
        String details = "";//用字符串拼接实现明细的记录
        double money = 0;
        double balance = 0;
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm");
        //用于日期的格式化
        String reason = "";//消费的原因

        public void showMenu(){
            do {
                System.out.println("========零钱通========");
                System.out.println("\t1.零钱通明细");
                System.out.println("\t2.收益入账");
                System.out.println("\t3.消费");
                System.out.println("\t4.退出");
                System.out.print("请选择(1-4)：");
                key = scanner.next();
                switch (key){
                    case "1"://明细
                        showDetails();
                        break;
                    case "2":
                        income();
                        break;
                    case "3":
                        pay();
                        break;
                    case "4":
                        toExit();
                        break;
                    default:
                        System.out.println("输入有误");

                }
            }while(loop);
            System.out.println("感谢使用");
        }

        public void showDetails(){
            System.out.println("========零钱通明细========");
            System.out.println(details);
        }

        public void income(){
            System.out.print("输入入账金额:");
            money = scanner.nextDouble();
            if (money <= 0){
                System.out.println("输入有误，所输入的金额应该 > 0");
                return; //结束此方法
            }
            balance += money;
            date =new Date(); //获取当前日期
            details += "\n收益入账\t\t\t+"+money+"\t\t"+sdf.format(date)+"\t余额："+balance;
        }

        public void pay(){
            System.out.print("输入支出途径：");
            reason = scanner.next();
            System.out.print("输入支出金额:");
            money = scanner.nextDouble();
            if (money > balance){
                System.out.println("支出大于余额，输入有误");
                return;
            }
            balance -= money;
            date = new Date();
            details += "\n"+reason+"\t\t\t-"+money+"\t"+sdf.format(date)+"\t余额："+balance;
        }

        public void toExit(){
            System.out.println("是否确认退出？是请输入Y 输入N则继续使用");
            String flag ;
            flag = scanner.next();
            if (flag.equals("Y")){
                loop = false;
            }else if(flag.equals("N")){
                loop = true;
            }
        }
}
