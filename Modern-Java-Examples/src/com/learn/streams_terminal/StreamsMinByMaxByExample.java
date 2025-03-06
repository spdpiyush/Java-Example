package com.learn.streams_terminal;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsMinByMaxByExample {

    public static void main(String[] args) {

        Optional<Student> minGpaStudent = minByExample();
        if (minGpaStudent.isPresent()) {
            System.out.println("Minimum GPA Student : " + minGpaStudent.get());
        }
        Optional<Student> maxGpaStudent = maxByExample();
        if (maxGpaStudent.isPresent()) {
            System.out.println("Maximum GPA Student : " + maxGpaStudent.get());
        }
    }

    /**
     * <p>
     *     minBy() takes i/p as Comparator.
     *     Get the Student who has the least GPA.
     * </p>
     * @return
     */
    public static Optional<Student> minByExample() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));
    }

    /**
     * <p>
     *     maxBy() takes i/p as Comparator.
     *     Get the Student who has the Highest GPA.
     * </p>
     * @return
     */
    public static Optional<Student> maxByExample() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));
    }
}
