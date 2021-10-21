package com.tommylearning.extendExercise;

public class Notepad extends Computer{
    private String color;

    public Notepad(String cpu,String disk,int ram,String color){
        super(cpu,disk,ram);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void showDetails(){
        System.out.println(getDetails()+" Color:"+color);
    }
}
