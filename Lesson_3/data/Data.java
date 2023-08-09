package Lesson_3.data;

public class Data {
    String lastName;

    String firstName;

    String patronymic;
    String date;
    Long numberPhone;
    Character gender;

    public Data() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNumberPhone(Long numberPhone) {
        this.numberPhone = numberPhone;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public boolean isEmpty() {
        return this.lastName == null
                || this.firstName == null
                || this.patronymic == null
                || this.date == null
                || this.numberPhone == null
                || this.gender == null;
    }

    @Override
    public String toString() {
        return "<" + lastName + ">" +
                "<" + firstName + ">" +
                "<" + patronymic + ">" +
                "<" + date + ">" +
                "<" + numberPhone + ">" +
                "<" + gender + ">\n";
    }
}