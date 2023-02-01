package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.function.Try;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

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
        Student resultingStudent;

        try{
            resultingStudent = studentDB.findById(1);
        }catch(Exception e){
            resultingStudent=null;
        }

        // THEN
        Assertions.assertEquals(s1, resultingStudent);
    }

    @Test
    void testFindById_NotFound() {
         // WHEN
        Exception e = Assertions.assertThrows(NoSuchElementException.class, () -> {
            studentDB.findById(9);
        }, "Expected exception");
        // THEN
        Assertions.assertEquals("Student does not exist", e.getMessage());
    }
}

//    @Test
//    void testExpectedException() {
//
//        NumberFormatException thrown = Assertions.assertThrows(NumberFormatException.class, () -> {
//            Integer.parseInt("One");
//        }, "NumberFormatException was expected");
//
//        Assertions.assertEquals("For input string: \"One\"", thrown.getMessage());
//    }

//    Map<String, Integer> hashMap = new HashMap<String, Integer>()
//    {{
//        put("One", 1);
//        put("Two", 2);
//        put("Three", 3);
//    }};
