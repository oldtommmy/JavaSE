package com.tommylearning.CoinSys1;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class CoinSys {
    public static void main(String[] args) {

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
                    System.out.println("========零钱通明细========");
                    System.out.println(details);
                    break;
                case "2":
                    System.out.print("输入入账金额:");
                    money = scanner.nextDouble();
                    if (money <= 0){
                        System.out.println("输入有误，所输入的金额应该 > 0");
                        break;
                    }
                    balance += money;
                    date =new Date(); //获取当前日期
                    details += "\n收益入账\t\t\t+"+money+"\t\t"+sdf.format(date)+"\t余额："+balance;
                    break;
                case "3":
                    System.out.print("输入支出途径：");
                    reason = scanner.next();
                    System.out.print("输入支出金额:");
                    money = scanner.nextDouble();
                    if (money > balance){
                        System.out.println("支出大于余额，输入有误");
                        break;
                    }
                    balance -= money;
                    date = new Date();
                    details += "\n"+reason+"\t\t\t-"+money+"\t"+sdf.format(date)+"\t余额："+balance;
                    break;
                case "4":
                    System.out.println("是否确认退出？是请输入Y 输入N则继续使用");
                    String flag ="";
                    flag = scanner.next();
                    if (flag.equals("Y")){ //注意此处不能用 ==
                        loop = false;      //== 如果判断引用类型，判断的是地址是否相等，即判定是不是同一个对象
                        break;             //而String的equals方法重写后比较的是字符串的内容
                    }else if(flag.equals("N")){
                        loop = true;
                    }
                    break;
                default:
                    System.out.println("输入有误");

            }
        }while(loop);
        System.out.println("=======感谢使用=======");
    }
}
