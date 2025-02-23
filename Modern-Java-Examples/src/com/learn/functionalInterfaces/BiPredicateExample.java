package com.learn.functionalInterfaces;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class BiPredicateExample {

    /**
     * Same as Predicate, but BiPredicate accepts 2 parameters.
     */
    static BiPredicate<Integer, Double> biPredicate = (gradeLevel, gpa) -> gradeLevel >= 2 && gpa >= 3.9;
    static BiConsumer<Integer, Double> biConsumer = (gradeLevel, gpa) -> System.out.println("GradeLevel = " + gradeLevel + " Gpa = " + gpa);

    public static void main(String[] args) {

        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(student -> {
            if (biPredicate.test(student.getGradeLevel(), student.getGpa())) {
                biConsumer.accept(student.getGradeLevel(), student.getGpa());
            }
        });

    }
}
