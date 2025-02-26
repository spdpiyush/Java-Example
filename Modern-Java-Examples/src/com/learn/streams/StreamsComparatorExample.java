package com.learn.streams;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsComparatorExample {

    public static void main(String[] args) {

        sortStudentsByName().forEach(System.out::println);

        sortStudentsByGpa().forEach(System.out::println);

    }

    /**
     * <p>
     *     Students need to be sorted by their name
     * </p>
     */
    public static List<Student> sortStudentsByName() {
        System.out.println("Sorted by Name:");
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    /**
     * <p>
     *     Sort the Students by their GPA in Decreasing Order.
     *     used reversed() to reverse the result and return the Collection.
     * </p>
     * @return
     */
    public static List<Student> sortStudentsByGpa() {
        System.out.println("Sorted By Gpa: ");
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(Collectors.toList());
    }
}
