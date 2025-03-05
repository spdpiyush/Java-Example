package com.learn.streams_terminal;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.stream.Collectors;

/**
 * <p>
 *     <code>counting()</code> Collector returns the total number of elements
 *     as a result.
 * </p>
 */
public class StreamsCountingExample {

    public static void main(String[] args) {

        System.out.println("counting1 : " + counting1());

        System.out.println("counting2 : " + counting2());
    }

    /**
     * return total number of students
     * @return
     */
    public static long counting1() {
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.counting()); // it's going to return total number of element reached collect() method.
    }

    /**
     * return total number of students with GPA >=  3.9
     * @return
     */
    public static long counting2() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getGpa)
                .filter(gpa -> gpa >= 3.9)
                .collect(Collectors.counting());
    }
}
