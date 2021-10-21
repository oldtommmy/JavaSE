package com.tommylearning.houseRent.view;

//1.显示界面
//2.接受用户的输入
//3.调用HouseService完成对房屋信息的各种操作

import com.tommylearning.houseRent.domain.House;
import com.tommylearning.houseRent.service.HouseService;
import com.tommylearning.houseRent.utils.Utility;

import java.util.Scanner;

public class HouseView {

    private boolean loop = true;
    private String key;
    private HouseService houseService = new HouseService(1);

    //编写updateHouse方法 根据ID修改房源信息
    public void updateHouse(){
        System.out.println("=======修改房源=======");
        System.out.println("请选择待修改房屋编号(-1表示退出)");
        int changeId = Utility.readInt();
        if (changeId == -1){
            return;
        }

        House house = houseService.find(changeId);
        if (house == null){
            System.out.println("===修改失败，未找到该房屋===");
            return;
        }

        System.out.print("Name(" + house.getName() + "): ");
        String name = Utility.readString(8, "");//这里如果用户直接回车表示不修改该信息,默认""
        if (!"".equals(name)) {//修改
            house.setName(name);
        }

        System.out.print("Phone(" + house.getPhone() + "):");
        String phone = Utility.readString(12, "");
        if (!"".equals(phone)) {
            house.setPhone(phone);
        }
        System.out.print("Address(" + house.getAddress() + "): ");
        String address = Utility.readString(18, "");
        if (!"".equals(address)) {
            house.setAddress(address);
        }
        System.out.print("Rent(" + house.getRent() + "):");
        int rent = Utility.readInt(-1);
        if (rent != -1) {
            house.setRent(rent);
        }
        System.out.print("State(" + house.getState() + "):");
        String state = Utility.readString(3, "");
        if (!"".equals(state)) {
            house.setState(state);
        }
        System.out.println("==========修改房屋信息成功========");
    }

    //编写delHouse方法
    public void delHouse(){
        System.out.println("==========删除房源==========");
        System.out.println("请输入要删除的房源的id: ");
        int delId = Utility.readInt();
        if (houseService.delete(delId)){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败，没有找到该房源");
        }
    }

    //编写findHouse方法
    public void findHouse(){
        System.out.print("请输入要查找的id: ");
        int id = Utility.readInt();
        if (houseService.find(id)!=null){
            System.out.println(houseService.find(id));
        }else{
            System.out.println("没有找到该房屋");
        }
    }

    //编写addHouse方法
    public void addHouse(){
        System.out.println("==========添加房屋=========");
        System.out.print("Name：");
        String name = Utility.readString(8);
        System.out.print("Phone：");
        String phone = Utility.readString(12);
        System.out.print("Address：");
        String address = Utility.readString(15);
        System.out.print("Rent：");
        int rent = Utility.readInt();
        System.out.print("State：");
        String state = Utility.readString(10);
        //创建一个新对象 注意ID是系统分配的
        House house = new House(0,name,phone,address,rent,state);
        if (houseService.add(house)){
            System.out.println("======成功添加=======");
        }else{
            System.out.println("======添加失败=======");
        }
    }


    //编写listHouses方法 显示房屋列表
    public void listHouses(){
        System.out.println("==========房屋列表=========");
        System.out.println("编号\t 房主\t 电话\t 地址\t 月租\t 状态\t");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null){
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("=========房屋列表完成========");
    }
    //展示主菜单
    public void mainMenu(){

        do {
            System.out.println("=======房屋出租系统=======");
            System.out.println("\t\t1 新 增 房 源");
            System.out.println("\t\t2 查 找 房 源");
            System.out.println("\t\t3 删 除 房 源");
            System.out.println("\t\t4 修 改 房 源 信 息");
            System.out.println("\t\t5 房 屋 列 表");
            System.out.println("\t\t6 退 出 系 统");
            System.out.print("请选择(1-6)：");
            Scanner scanner = new Scanner(System.in);
            key = scanner.next();

            switch (key){
                case "1":
                    addHouse();
                    break;
                case "2":
                    findHouse();
                    break;
                case "3":
                    delHouse();
                    break;
                case "4":
                    updateHouse();
                    break;
                case "5":
                    listHouses();
                    break;
                case "6":
                    loop = false;
                    System.out.println("\t\t退 出 系 统");
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
            }
        }while (loop);

    }
}
