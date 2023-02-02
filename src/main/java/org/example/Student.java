package org.example;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public record Student(
        String name,
        int id,
        LocalDate birthday
) {
    // Constructor with only two arguments, not provided by Record
    public Student(String name, int id) {
        this(name, id, null);
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
