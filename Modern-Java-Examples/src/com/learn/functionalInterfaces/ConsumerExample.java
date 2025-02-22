package com.learn.functionalInterfaces;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    static Consumer<Student> consumer2 = (student) -> System.out.println(student);
    static Consumer<Student> consumer3 = (student) -> System.out.print(student.getName());
    static Consumer<Student> consumer4 = (student) -> System.out.println(student.getActivities());

    public static void main(String[] args) {

        /**
         * Consumer takes input as String and print it as UpperCase String.
         */
        Consumer<String> consumer1 = (s) -> System.out.println(s.toUpperCase());
        consumer1.accept("input1");

        printStudents();

        printNameAndActivities();

        printNameAndActivitiesUsingCondition();
    }

    public static void printStudents() {

        System.out.println("printStudents()::invoked ");
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(consumer2);
    }

    public static void printNameAndActivities() {
        System.out.println("printNameAndActivities()::invoked");
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(consumer3.andThen(consumer4)); // consumer chaining
    }

    public static void printNameAndActivitiesUsingCondition() {
        System.out.println("printNameAndActivitiesUsingCondition()::invoked");
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(student -> {
            if (student.getGradeLevel() >= 3) {
                consumer3.andThen(consumer4).accept(student);
            }
        });
    }

}
