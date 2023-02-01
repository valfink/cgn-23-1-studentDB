package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class StudentDB {

    private Map<Integer,String> studentList;

    public StudentDB(Map<Integer, String> studentList) {
        this.studentList = studentList;
    }

    public Map<Integer,String> getAllStudents(){
        return studentList;
    }

    @Override
    public String toString() {
        return "StudentDB{" +
                "studentList=" + studentList +
                '}';
    }

    public String randomStudent(){
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
        studentList.put(newStudent.getId(), newStudent.getName());
    }

    public void removeStudent(Student exStudent){
        studentList.remove(exStudent);
    }

}
