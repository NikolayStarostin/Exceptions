package Lesson_3.model;

import Lesson_3.data.Data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {
    private final Data data = new Data();

    public Model(String input) {
        List<String> array = new ArrayList<>(Arrays.asList(input.trim().split(" ")));
        try {
            if (isValidSize(array)) {
                for (int i = 0; i < array.size(); i++) {
                    if (isValidDate(array.get(i))
                            || isValidNumber(array.get(i))
                            || isValidGender(array.get(i))) {
                        array.remove(i);
                        i--;
                    }
                }
                if (array.size() == 3) {
                    data.setLastName(array.get(0));
                    data.setFirstName(array.get(1));
                    data.setPatronymic(array.get(2));
                    this.write();
                } else {
                    throw new RuntimeException();
                }
            }
        } catch (RuntimeException e) {
            System.out.println("ОШИБКА ввода ->" + array + "\n");
        }
    }

    private void write() {
        String path = "C:\\ProjectJava" +
                "\\Java\src\\main\\resources\\" + data.getLastName().toLowerCase() + ".txt";
        File file = new File(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            if (!file.exists()) file.createNewFile();
            writer.write(data.toString());
            System.out.println("Запись сохранена...\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean isValidSize(List<String> array) {
        try {
            if (array.size() < 6) throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("Введите достаточное количество данных\n");
            return false;
        }
        try {
            if (array.size() > 6) throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("Превышено введенное значение данных\n");
            return false;
        }
        return true;
    }

    private boolean isValidDate(String input) {
        if (input.matches("[0-3]\\d.[01]\\d.[12][09]\\d{2}")) {
            this.data.setDate(input);
            return true;
        } else return false;
    }

    private boolean isValidNumber(String input) {
        if (input.matches("[78][89]\\d{9}")) {
            this.data.setNumberPhone(Long.parseLong(input));
            return true;
        } else return false;
    }

    private boolean isValidGender(String input) {
        if (input.length() == 1 && (input.equalsIgnoreCase("f") || input.equalsIgnoreCase("m"))) {
            this.data.setGender(input.charAt(0));
            return true;
        } else return false;
    }
}