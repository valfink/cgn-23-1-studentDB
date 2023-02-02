package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String name;
    private int id;
    private LocalDate birthday;

    // Constructor with only two arguments, not provided by Lombok
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
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
