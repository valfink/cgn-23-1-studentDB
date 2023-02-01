package org.example;

import java.time.LocalDate;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.DAYS;

public class Student {

    private String name;
    private int id;
    private LocalDate birthday;


    public Student(String name, int id, LocalDate birthday) {
        this.name = name;
        this.id = id;
        this.birthday=birthday;
    }
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (!Objects.equals(name, student.name)) return false;
        return Objects.equals(birthday, student.birthday);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String howLongUntilBirthday() {
        LocalDate actualDate= LocalDate.now();
        LocalDate nextBirthday = birthday.withYear(actualDate.getYear());
        if (nextBirthday.isBefore(actualDate)|| nextBirthday.isEqual(actualDate)) {
            nextBirthday = nextBirthday.plusYears(1);
        }
        // long p2 = ChronoUnit.DAYS.between(today, nextBDay);
        return name + "'s next birthday is in: " + DAYS.between(actualDate, nextBirthday) + " Days!";
    }
}
