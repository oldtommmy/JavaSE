package com.tommylearning.extendExercise;

public class Computer {
    private String cpu;
    private String disk;
    private int ram;

    public Computer(String cpu,String disk,int ram){
        this.cpu = cpu;
        this.disk = disk;
        this.ram = ram;
    }

    public String getDetails(){
        return "CPU:" +cpu+" Disk:"+disk+" Ram:"+ram;
    }

    public String getCpu() {
        return cpu;
    }

    public String getDisk() {
        return disk;
    }

    public int getRam() {
        return ram;
    }

}
