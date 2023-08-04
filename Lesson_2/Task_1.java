package Lesson_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        System.out.println("takeFloat() = " + takeFloat());
    }

    private static float takeFloat() {
        for (;;){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter valid number type float");
                return scanner.nextFloat();
            } catch (InputMismatchException e){
                System.out.println("Input was not number type float");
            }
        }
    }
}