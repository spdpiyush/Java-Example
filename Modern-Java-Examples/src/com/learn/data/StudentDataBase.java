package com.learn.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDataBase {

    /**
     * Dummy Student Data
     * @return
     */
    public static List<Student> getAllStudents() {

        List<Student> studentList= new ArrayList<>();

        Student student1 = new Student("Adam", 2, "male", 4.5, Arrays.asList("swimming", "basketball"));
        Student student2 = new Student("Jenny", 2, "female", 3.6, Arrays.asList("swimming", "soccer"));


        Student student3 = new Student("Emily", 3, "female", 4.5, Arrays.asList("swimming", "basketball", "football"));
        Student student4 = new Student("Dave", 3, "male", 3.9, Arrays.asList("swimming", "basketball"));


        Student student5 = new Student("Sophia", 4, "female", 3.5, Arrays.asList("swimming", "basketball", "dancing"));
        Student student6 = new Student("James", 4, "male", 6.5, Arrays.asList("swimming", "basketball"));

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
        return studentList;
    }
}

