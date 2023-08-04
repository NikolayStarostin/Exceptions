package Lesson_2;

import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите строку: ");
            String string = scanner.nextLine();
            if (string.isEmpty())
                throw new RuntimeException("Пустые строки вводить нельзя");
        } catch (RuntimeException e) {
            System.out.println("Исключение: " + e);
        }
    }
}