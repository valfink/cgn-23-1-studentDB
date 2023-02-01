package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class StudentTest {



    @Test
    void testBirthday_this_year(){

        LocalDate alexBirthday = LocalDate.now().plusDays(7).minusYears(20);
        Student studentB = new Student("Alex",100,alexBirthday);
        String howLong = studentB.howLongUntilBirthday();
        System.out.println(howLong);

        assertEquals("Alex's next birthday is in: 7 Days!", howLong);

    }

    @Test
    void testBirthday_next_year(){

        LocalDate alexBirthday = LocalDate.now().minusDays(7).minusYears(20);
        Student studentB = new Student("Alex",100,alexBirthday);
        String howLong = studentB.howLongUntilBirthday();
        System.out.println(howLong);

        assertEquals("Alex's next birthday is in: 358 Days!", howLong);

    }

    @Test
    void testBirthday_next_year_today(){

        LocalDate alexBirthday = LocalDate.now().minusYears(20);
        Student studentB = new Student("Alex",100,alexBirthday);
        String howLong = studentB.howLongUntilBirthday();
        System.out.println(howLong);

        assertEquals("Alex's next birthday is in: 365 Days!", howLong);

    }
}