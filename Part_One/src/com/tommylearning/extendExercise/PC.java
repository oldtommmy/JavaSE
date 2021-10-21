package com.tommylearning.extendExercise;

public class PC extends Computer {

    private String brand;

    public PC(String cpu,String disk,int ram,String brand){
        super(cpu, disk, ram);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void showDetails() {
        System.out.println(getDetails()+" Brand:"+brand);
    }
}
