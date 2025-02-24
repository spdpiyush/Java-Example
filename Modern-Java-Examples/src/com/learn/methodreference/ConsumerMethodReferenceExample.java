package com.learn.methodreference;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.function.Consumer;

public class ConsumerMethodReferenceExample {

    /**
     * ClassName::methodName
     */
    static Consumer<Student> consumer = System.out::println;

    /**
     * ClassName::instanceMethodName
     */
    static Consumer<Student> consumer1 = Student::printActivities;

    public static void main(String[] args) {

        StudentDataBase.getAllStudents()
                .forEach(consumer);

        StudentDataBase.getAllStudents()
                .forEach(consumer1);
    }
}
