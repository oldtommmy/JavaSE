package com.tommylearning.exDoctor;

import javax.print.Doc;

public class test {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("Chan", 29, '男', 13000);
        Doctor doctor1 = new Doctor("Jack", 29, '男', 16000);
        Doctor doctor2 = new Doctor("Chan", 29, '男', 13000);
        System.out.println(doctor.equals(doctor1));
        System.out.println(doctor.equals(doctor2));
    }
}
