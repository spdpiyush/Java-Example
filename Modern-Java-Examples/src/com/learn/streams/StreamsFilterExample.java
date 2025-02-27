package com.learn.streams;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsFilterExample {


    public static void main(String[] args) {
        filterStudent().forEach(System.out::println);

    }

    /**
     * <p>
     *     Filter Female Student with gradeLevel greater than or equal to 3.
     * </p>
     * @return
     */
    public static List<Student> filterStudent() {
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGender().equalsIgnoreCase("female"))
                .filter(student -> student.getGradeLevel() >= 3)
                .collect(Collectors.toList());

    }
}
