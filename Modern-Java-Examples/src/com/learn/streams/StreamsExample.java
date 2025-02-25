package com.learn.streams;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {

    public static void main(String[] args) {

        // we want student name and their activities in a Map
        Map<String, List<String>> studentActivitiesMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.toMap(Student::getName, Student::getActivities));

        /**
         * collect method starts the whole process.
         */
        System.out.println(studentActivitiesMap);

        // with filter
        Map<String, List<String>> studentActivitiesMapWithFilter = StudentDataBase.getAllStudents()
                .stream()
                .filter(student -> student.getGradeLevel() >= 3)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        System.out.println(studentActivitiesMapWithFilter);

        Predicate<Student> predicate1 = student -> student.getGradeLevel() >= 3;
        Predicate<Student> predicate2 = student -> student.getGpa() >= 3.9;
        Map<String, List<String>> studentActivitiesMapWithTwoFilter = StudentDataBase.getAllStudents()
                .stream()
                .filter(predicate1)
                .filter(predicate2)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        System.out.println(studentActivitiesMapWithTwoFilter);

        Predicate<Student> predicate4 = (student -> {
            System.out.println(student);
            return student.getGradeLevel() >= 3;
        });

        /**
         * collect method starts the whole process.
         * if we don't have collect then this won't even start.
         * Streams are Lazy.
         * i.e. No Intermediate Operations will be invoked until the terminal operation is invoked.
         */
        StudentDataBase.getAllStudents()
                .stream()
                .filter(predicate4);
    }
}
