package com.tommychan.learning.exercise;
//要求如下：
//1，有一个交通工具接口类Vehicles，有work接口
//2,有Horse类和Boat类分别实现Vehicles
//3，创建交通工具工厂类，有两个方法分别获得交通工具Horse和Boat
//4，有Person类，有name和Vehicles属性，在构造器中为两个属性赋值
//5，实例化Person对象“唐僧”，要求一般情况下用Horse作为交通工具，遇到大河时用Boat作为交通工具

public class Exercise01 {
    public static void main(String[] args) {
        Person tang = new Person("Tang", new Boat());
        tang.passRiver();
        tang.passRoad();
    }
}

interface Vehicles{
    public void work();
}

class Horse implements Vehicles{
    @Override
    public void work() {
        System.out.println("Horse is used");
    }
}

class Boat implements Vehicles{
    @Override
    public void work() {
        System.out.println("Boat is used");
    }
}

class Factory{

    //避免每次重新创建新的Horse对象 采用饿汉式
    private static Horse horse = new Horse();
    private Factory(){};
    public static Horse getHorse(){ //使用static方法 避免创建Factory对象
        return horse;
    }

    public static Boat getBoat(){
        return new Boat();
    }
}

class Person{
    private String name;
    private Vehicles vehicles;

    public Person(String name,Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void passRiver(){
        if (!(vehicles instanceof Boat)){ //判断当前的vehicles
            vehicles = Factory.getBoat(); //若不是Boat 则重新返回一个Boat
        }                                 //这种判断方式同时可以防止vehicles为null的情况
                                          //同时当情况大于等于3时 也可以完美判断
        vehicles.work();                  //此处也体现了接口的多态 避免了重新创建一个Boat的对象来调用work方法
    }

    public void passRoad(){
        if (!(vehicles instanceof Horse)){//原因同上
            vehicles = Factory.getHorse();
        }
        vehicles.work();
    }
}
