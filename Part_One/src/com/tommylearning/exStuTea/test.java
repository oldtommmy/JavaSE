package com.tommylearning.exStuTea;

public class test {
    public static void main(String[] args) {
        Person[] person = new Person[4];
        person[0] = new Student("Tommy","man",19,001);
        person[1] = new Student("Jerry","man",17,002);
        person[2] = new Teacher("kitty","woman",32,101);
        person[3] = new Teacher("jason","man",28,110);

        for (int i = 0; i < person.length; i++) {
            if(person[i] instanceof Student){
                Student student = (Student) person[i];
                System.out.println(student.play());
            }
            if(person[i] instanceof Teacher){
                Teacher teacher = (Teacher) person[i];
                System.out.println(teacher.play());
            }
        }

    }
}
