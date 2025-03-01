package com.learn.streams;

import com.learn.data.StudentDataBase;

public class StreamsMatchExample {

    public static void main(String[] args) {

        System.out.println("Result of allMatch() : " + allMatch());

        System.out.println("Result of anyMatch() : " + anyMatch());

        System.out.println("Result of noneMatch() : " + noneMatch());
    }

    /**
     * <p>
     *     allMatch() takes i/p as Predicate.
     *     This is going to check whether all the Students in the stream has a GPA >= 3.9.
     * </p>
     * @return
     */
    public static boolean allMatch() {
        return StudentDataBase.getAllStudents().stream()
                .allMatch(student -> student.getGpa() >= 3.9);
    }

    /**
     * <p>
     *     anyMatch() takes i/p as Predicate.
     *     This is going to check whether any of the Students in the stream has a GPA >= 3.9.
     * </p>
     * @return
     */
    public static boolean anyMatch() {
        return StudentDataBase.getAllStudents().stream()
                .anyMatch(student -> student.getGpa() >= 3.9);
    }


    /**
     * <p>
     *     noneMatch() takes i/p as Predicate.
     *     noneMatch() is just Opposite of allMatch().
     *     This is going to check whether none of the Students in the stream has a GPA >= 4.1.
     * </p>
     * @return
     */
    public static boolean noneMatch() {
        return StudentDataBase.getAllStudents().stream()
                .noneMatch(student -> student.getGpa() >= 4.1);
    }
}
