package com.tommychan.learning.interface_.interfaceArray;

public class Phone implements Usb {
    @Override
    public void start() {
        System.out.println("Phone starts  working");
    }

    public void call(){
        System.out.println("Phone can make a call");
    }
}
