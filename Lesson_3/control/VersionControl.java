package Lesson_3.control;

import Lesson_3.model.Model;

public class VersionControl implements Control {
    @Override
    public void execute(String input) {
        new Model(input);
    }
}