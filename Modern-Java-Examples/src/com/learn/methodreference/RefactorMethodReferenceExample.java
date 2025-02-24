package com.learn.methodreference;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.function.Predicate;

public class RefactorMethodReferenceExample {

    static Predicate<Student> studentPredicate = (student) -> student.getGradeLevel() >= 3;

    static Predicate<Student> predicateWithMethodReference = RefactorMethodReferenceExample::gradeLevelGreaterThanThree;

    public static void main(String[] args) {

        System.out.println(studentPredicate.test(StudentDataBase.studentSupplier.get()));

        System.out.println(predicateWithMethodReference.test(StudentDataBase.studentSupplier.get()));
    }

    public static boolean gradeLevelGreaterThanThree(Student student) {
        return student.getGradeLevel() >= 3;
    }
}
