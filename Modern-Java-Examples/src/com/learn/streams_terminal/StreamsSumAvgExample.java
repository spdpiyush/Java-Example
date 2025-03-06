package com.learn.streams_terminal;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.stream.Collectors;

public class StreamsSumAvgExample {

    public static void main(String[] args) {

        System.out.println("Total Number of Notebooks : " + summingIntExample());

        System.out.println("Average Number of Notebooks : " + averagingIntExample());
    }

    /**
     * <p>
     *     This is going to return Summation of all the notebooks from all the Students.
     * </p>
     * @return
     */
    public static int summingIntExample() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.summingInt(Student::getNoteBooks));
    }

    /**
     * <p>
     *     This is going to return average number of notebooks each student have.
     * </p>
     * @return
     */
    public static double averagingIntExample() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.averagingInt(Student::getNoteBooks));
    }
}
