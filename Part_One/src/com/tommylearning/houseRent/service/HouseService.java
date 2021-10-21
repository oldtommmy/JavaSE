package com.tommylearning.houseRent.service;

//HouseService.java＜＝＞类［业务层］
//定义 House[]，保存House对象
//1．响应 HouseView 的调用
//2．完成对房屋信息的各种操作(增删改査 crud——c［create］r［read］u［update］d［delete］)

import com.tommylearning.houseRent.domain.House;

public class HouseService {
    private House[] houses; //保存House类对象
    private int houseNum = 1;//记录当前房屋数量
    private int idCounter = 1;
    //构造器
    public HouseService(int size){ //创建HouseService对象时指定数组大小
        houses = new House[size];
        houses[0] = new House(001,"Jack","622302","Beijing",3500,"On sale");
    }

    //delete方法 用于删除
    public boolean delete(int delId){
        //遍历找到该房源 可使用find方法
        int index = -1;
        for (int i = 0; i < houses.length; i++) {
            if (houses[i].getId()==delId){
                index = i;
                break;
            }
        }
        if(index == -1){
            return false;
        }else{
            for (int i = index; i < houses.length-1; i++) {
                houses[i]=houses[i+1];
            }
            houses[houses.length-1] = null;
            houseNum--;
        }
        return true;
    }

    //find方法 用于查找
    public House find(int id){
        for (int i = 0; i < houses.length; i++) {
            if (houses[i].getId()==id){
                return houses[i];
            }
        }
        return null;
    }

    //add 方法 添加新的对象
    public boolean add(House newHouse){
        //判断是否可以继续添加（空间问题）
        if (houseNum == houses.length){
            int i;
            House[] newHouses = new House[houses.length+1];
            for (i = 0; i < houses.length; i++) {
                newHouses[i] = houses[i];
            }
            newHouse.setId(++idCounter);
            newHouses[houseNum++] = newHouse;
            houses = newHouses;
            return true;
        }

        houses[houseNum++] = newHouse;
        newHouse.setId(++idCounter); //更新房屋ID 实现ID自增长
        return true;
    }

    //list方法返回House数据
    public House[] list(){
        return houses;
    }
}
