package com.learn.optional;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.Optional;


public class OptionalExample {

    public static void main(String[] args) {

        String studentName = getStudentName();
        if (studentName != null) {
            System.out.println("Length of Student Name " + studentName.length());
        }else {
            System.out.println("Name not found.");
        }


        Optional<String> studentNameOptional = getStudentNameOptional();
        if (studentNameOptional.isPresent()) {
            System.out.println("Length of Student Name Optional : " + studentNameOptional.get().length()); // to get actual value inside Optional.
        }else {
            System.out.println("Name not found.");
        }

    }

    /**
     * Too many null Checks.
     * @return
     */
    public static String  getStudentName() {
        Student student = StudentDataBase.studentSupplier.get();
        // if student == null, then it return null
        if (student == null) {
            return null;
        }
        return student.getName();
    }

    public static Optional<String> getStudentNameOptional() {
        // wrapping actual Student Object within Optional
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());

        // Checks whether is this Optional Object has any value inside that object or not.
        if (studentOptional.isPresent()) {
            return studentOptional.map(Student::getName); // this return Optional<String>
        }
        return Optional.empty(); // Represents an Optional Object with no value.
    }
}
