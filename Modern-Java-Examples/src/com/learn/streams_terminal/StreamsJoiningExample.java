package com.learn.streams_terminal;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.stream.Collectors;

/**
 * joining() Collector used to concatenates the input elements into a
 * {@code String}, in encounter order.
 */
public class StreamsJoiningExample {

    public static void main(String[] args) {

        System.out.println("joining1 : " + joining1());

        System.out.println("joining2 : " + joining2());

        System.out.println("joining3 : " + joining3());
    }

    /**
     * <p>
     *     Concatenate all the names that are in StudentDataBase and return as result.
     * </p>
     * @return
     */
    public static String joining1() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining());
    }


    /**
     * <p>
     *     Concatenate all the names by passing a delimiter.
     * </p>
     * @return
     */
    public static String joining2() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining(" "));
    }

    /**
     * <p>
     *     Concatenate all the names by passing Prefix and Suffix.
     * </p>
     * @return
     */
    public static String joining3() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining(" , ", "[  ", " ]"));
    }
}
