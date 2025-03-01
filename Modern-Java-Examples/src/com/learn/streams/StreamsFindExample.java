package com.learn.streams;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.Optional;

public class StreamsFindExample {

    public static void main(String[] args) {

        Optional<Student> studentOptionalFindAny = findAnyStudent();
        if (studentOptionalFindAny.isPresent()) {
            System.out.println(studentOptionalFindAny.get());
        }

        Optional<Student> studentOptionalFindFirst = findFirstStudent();
        if (studentOptionalFindFirst.isPresent()) {
            System.out.println(studentOptionalFindFirst.get());
        }
    }


    /**
     * <p>
     *     findFirst() : Returns the first element it finds ar per condition in the stream.
     * </p>
     * @return
     */
    public static Optional<Student> findFirstStudent() {
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa() >= 3.9)
                .findFirst();
    }

    /**
     * <p>
     *     findAny() : Returns the first encountered element int the stream.
     * </p>
     * @return
     */
    public static Optional<Student> findAnyStudent() {
        return StudentDataBase.getAllStudents().stream()
                // it checked for Adam, Jenny, and Emily
                .filter(student -> student.getGpa() >= 3.9)
                // as soon it found a student with this filter criteria, it returned that student
                // and it did not not execute any one of the other student below this.
                .findAny();
    }

}
