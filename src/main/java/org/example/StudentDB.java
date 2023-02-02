package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDB {

    private Map<Integer,Student> studentList;

    public Map<Integer,Student> getAllStudents(){
        return studentList;
    }


    public Student randomStudent(){
        List<Integer> possibleKeys = new ArrayList<>();
        for ( Integer key : studentList.keySet() ) {
            possibleKeys.add( key );
        }
        int randomIndex = (int) (Math.random()*possibleKeys.size());
        Integer randomKey = possibleKeys.get(randomIndex);
        return studentList.get(randomKey);
    }

    public void addStudent(Student newStudent){
        studentList.put(newStudent.id(), newStudent);
    }

    public void removeStudent(Student exStudent){
        studentList.remove(exStudent);
    }

    public Optional<Student> findById(int id) {
        for (Student student : studentList.values()) {
            if (student.id() == id) {
                return Optional.ofNullable(student);
            }
        }
        return Optional.empty();
    }
}
