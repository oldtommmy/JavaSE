package com.tommylearning.exercise2;

public class test {
    public static void main(String[] args) {
        Professor professor = new Professor("Li",45,"C++ ",4500);
        AssociateProfessor associateProfessor = new AssociateProfessor("Jie",44,"C Class",4500);
        Talker talker = new Talker("Yu",23,"Manager",3000);

        System.out.println(professor.introduce());
        System.out.println(associateProfessor.introduce());
        System.out.println(talker.introduce());
    }
}
