package com.learn.parallelstream;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamExample1 {

    public static void main(String[] args) {
        sequentialStudentActivities();
        parallelStudentActivities();
    }

    public static List<String> sequentialStudentActivities() {
        long startTime = System.currentTimeMillis();
        List<String> studentActivities = StudentDataBase.getAllStudents()
                .stream() //Stream<Student>
                .map(Student::getActivities) // Stream<List<String>> -- stateless
                .flatMap(List::stream) // Stream<String> -- stateless
                .distinct() // stateful
                .sorted() //stateful
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential Time Take = " +  (endTime - startTime));
        return studentActivities;
    }

    public static List<String> parallelStudentActivities() {
        long startTime = System.currentTimeMillis();
        List<String> studentActivities = StudentDataBase.getAllStudents()
                .stream()
                .parallel()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Parallel Time Take = " +  (endTime - startTime));
        return studentActivities;
    }
}
