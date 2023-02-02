package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Optional;

public class StudentDBTest {
    // GIVEN
    Student s1;
    Student s2;
    Student s3;
    Student s4;
    StudentDB studentDB;

    @BeforeEach
    void init() {
        // GIVEN
        s1 = new Student("Ana", 1);
        s2 = new Student("Tony", 2);
        s3 = new Student("Johannes", 3);
        s4 = new Student("Valentin", 4);

        studentDB = new StudentDB(new HashMap<>()
        {{
            put(s1.hashCode(), s1);
            put(s2.hashCode(), s2);
            put(s3.hashCode(), s3);
            put(s4.hashCode(), s4);
        }});
    }

    @Test
    void testFindById_successful() {
         // WHEN
        Optional<Student> resultingStudent = studentDB.findById(1);

        // THEN
        Assertions.assertEquals(s1, resultingStudent.orElse(null));
    }

//    Version of Test with Exception Assertion, but Method has been changed to Optional!
//    @Test
//    void testFindById_NotFound() {
//         // WHEN
//        Exception e = Assertions.assertThrows(NoSuchElementException.class, () -> {
//            studentDB.findById(9);
//        }, "Expected exception");
//        // THEN
//        Assertions.assertEquals("Student with id 9 does not exist", e.getMessage());
//    }

    @Test
    void testFindById_NotFound() {
         // WHEN
        Optional<Student> resultingStudent = studentDB.findById(100);
        // THEN
        Assertions.assertNull(resultingStudent.orElse(null));
    }




}