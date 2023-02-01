package org.example;

import java.util.*;

public class StudentDB {

    private Map<Integer,Student> studentList;

    public StudentDB(Map<Integer, Student> studentList) {
        this.studentList = studentList;
    }

    public Map<Integer,Student> getAllStudents(){
        return studentList;
    }

    @Override
    public String toString() {
        return "StudentDB{" +
                "studentList=" + studentList +
                '}';
    }

    public Student randomStudent(){
        List<Integer> possibleKeys = new ArrayList<>();
        for ( Integer key : studentList.keySet() ) {
            possibleKeys.add( key );
        };
        int randomIndex = (int) (Math.random()*possibleKeys.size());
        Integer randomKey = possibleKeys.get(randomIndex);
        return studentList.get(randomKey);
    }
    /*
    (1, Valentin)
    (5, Hamideh)
    (20, Ana)
    (100, Daniel)
    */

    public void addStudent(Student newStudent){
        studentList.put(newStudent.getId(), newStudent);
    }

    public void removeStudent(Student exStudent){
        studentList.remove(exStudent);
    }

    public Student findById(int id) {
        for (Student student : studentList.values()) {
            if (student.getId() == id) {
                return student;
            }
        }
        throw new NoSuchElementException("Student with id " + id + " does not exist");
    }
}
