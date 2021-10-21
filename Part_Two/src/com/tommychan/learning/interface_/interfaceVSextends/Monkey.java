package com.tommychan.learning.interface_.interfaceVSextends;

public class Monkey {
    private String name;
    public void climb(){
        System.out.println("Monkey can climb");
    }

    public Monkey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class LilMonkey extends Monkey implements Fishable , Birdable{
    public LilMonkey(String name){
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(getName()+" learns how to fly like bird");
    }

    @Override
    public void swim() {
        System.out.println(getName()+" learns how to swim like fish");
    }
}