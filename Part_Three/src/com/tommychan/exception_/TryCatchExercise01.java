package com.tommychan.exception_;

import java.util.Scanner;

public class TryCatchExercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;

        while (true){
            System.out.println("Please input a int");
            try {
                Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }
    }
}
