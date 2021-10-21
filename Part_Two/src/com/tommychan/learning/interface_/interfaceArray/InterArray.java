package com.tommychan.learning.interface_.interfaceArray;

public class InterArray {
    public static void main(String[] args) {
        //多态数组 -> 接口类型数组
        Usb[] usbArray = new Usb[2];
        usbArray[0] = new Phone();
        usbArray[1] = new Camera();

        for (int i = 0; i < usbArray.length; i++) {
            usbArray[i].start();
            if (usbArray[i] instanceof Phone){
                Phone phone = (Phone) usbArray[i];
                phone.call();
            }
            System.out.println("==============");
        }
    }
}
