package com.tommylearning.exercise1;

public class test {
    public static void main(String[] args) {
        Person[] person = new Person[3]; //创建对象数组
        person[0]= new Person("Jack",18,"Worker");//每个对象的初始化
        person[1]= new Person("Mike",20,"Cleaner");
        person[2]= new Person("Charlie",21,"Teacher");
        bubbleSort(person);
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i].getName()+" "+person[i].getAge()+" "+person[i].getJob());
        }
    }

    static void bubbleSort(Person[] person){
        for (int i = 0; i < person.length-1; i++) {
            for (int j = 0; j < person.length-i-1; j++) {
                if (person[j].getAge()<person[j+1].getAge()){
                    Person temp = person[j]; //对象数组的对象之间的交换
                    person[j] = person[j+1]; //通过交换地址来实现
                    person[j+1] = temp;
                }
            }
        }
    }
}
