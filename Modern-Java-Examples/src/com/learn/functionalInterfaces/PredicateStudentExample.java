package com.learn.functionalInterfaces;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentExample {

    static Predicate<Student> predicate1 = (student) -> student.getGradeLevel() >= 3;
    static Predicate<Student> predicate2 = (student) -> student.getGpa() >= 3.9;

    public static void filterStudentByGradeLevel() {
        System.out.println("filterStudentByGradeLevel()::invoked");
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(student -> {
            if (predicate1.test(student)) {
                System.out.println(student);
            }
        });
    }

    public static void filterStudentByGradeLevelAndGpa() {

        System.out.println("filterStudentByGradeLevelAndGpa()::invoked");
        List<Student> students = StudentDataBase.getAllStudents();

        students.forEach(student -> {

            if (predicate1.and(predicate2).test(student)) {
                System.out.println(student);
            }
        });
    }
    public static void main(String[] args) {

        filterStudentByGradeLevel();

        filterStudentByGradeLevelAndGpa();
    }
}
