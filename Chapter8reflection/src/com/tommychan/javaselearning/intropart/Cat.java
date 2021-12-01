package com.tommychan.javaselearning.intropart;

public class Cat {
    private String name = "KiKi";
    public String color = "white";

    public Cat(){

    }

    public Cat(String color) {
        this.color = color;
    }

    public void hi() {
        System.out.println("I am KiKi!");
    }

    public void cry(){
        System.out.println("miao ~");
    }
}
