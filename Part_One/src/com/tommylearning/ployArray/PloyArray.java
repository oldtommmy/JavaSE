package com.tommylearning.ployArray;

public class PloyArray {
    public static void main(String[] args) {

        Person[] person = new Person[5];
        person[0] = new Person("Jack",18);
        person[1] = new Student("Mike",19,99.5,"Mid1");
        person[2] = new Student("Kate",19,89.5,"Mid2");
        person[3] = new Teacher("Tomson",29,9000,"Math");
        person[4] = new Teacher("David",56,12000,"PE");

        for (int i = 0; i < 5; i++) {

            if(person[i] instanceof Student){
                System.out.print(person[i].say());
                Student stu = (Student) person[i];
                stu.showGrade();
            }else if(person[i] instanceof Teacher){
                System.out.print(person[i].say());
                Teacher teacher = (Teacher) person[i];
                teacher.showCourse();
            }else{
                System.out.println(person[i].say());
            }

        }
    }
}
