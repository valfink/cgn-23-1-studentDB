package org.example;


import java.util.*;

public class Main {

    public static void main(String[] args) {

        Student hamideh = new Student("Hamideh", 1);
        Student ana = new Student("Ana", 2);
        Student daniel = new Student("Daniel", 3);
        Student valentin = new Student("Valentin", 4);

        /*List<Student> studentList = new ArrayList(){{
            add(hamideh);
            add(ana);
        }};*/
        Map<Integer,Student> studentList = new HashMap<>();
        studentList.put(hamideh.id(), hamideh);
        studentList.put(ana.id(), ana);
        studentList.put(daniel.id(), daniel);


        StudentDB database = new StudentDB(studentList);
        System.out.println(database.toString());
        // System.out.println(database.getAllStudents());
        // System.out.println(database.randomStudent());
        // database.addStudent(valentin);
        database.removeStudent(ana);
        System.out.println(database.toString());

        database.addStudent(valentin);
        System.out.println(database);






    }
}
