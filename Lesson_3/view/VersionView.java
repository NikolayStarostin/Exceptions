package Lesson_3.view;

import Lesson_3.control.Control;
import Lesson_3.control.VersionControl;

import java.util.Scanner;

public class VersionView implements View {
    private final Control control;

    public VersionView() {
        this.control = new VersionControl();
    }

    @Override
    public void start() {
        Scanner in = new Scanner(System.in).useDelimiter("\r?\n");
        while (true) {
            System.out.println("""
                    Введите данные в произвольном порядке, разделенные пробелом:
                    <ФИО дд.мм.гггг f|m>
                    введите [exit] для выхода""");
            String input = in.next();
            if (input.equalsIgnoreCase("exit")) System.exit(0);
            this.control.execute(input);
        }
    }
}