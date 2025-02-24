package com.learn.constructorreference;

import com.learn.data.Student;

import java.util.function.Supplier;

public class ConstructorReferenceExample {

    /**
     * Calls No-arg Constructor
     */
    static Supplier<Student> studentSupplier = Student::new;

    public static void main(String[] args) {

        /**
         * Create new Object of Student with default values
         */
        System.out.println(studentSupplier.get());
    }
}
