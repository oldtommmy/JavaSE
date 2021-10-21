package com.tommylearning.extendExercise;

public class test {
    public static void main(String[] args) {

        PC pc = new PC("M1","WestData",512,"Apple");
        Notepad notepad = new Notepad("i7","Samsung",512,"white");

        pc.showDetails();
        notepad.showDetails();

    }
}
