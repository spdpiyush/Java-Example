package com.learn.functionalInterfaces;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * <p>
 *     BiConsumer is an extension of Consumer.
 * </p>
 */
public class BiConsumerExample {

    public static void main(String[] args) {

        BiConsumer<String, String> biConsumer = (a, b) -> System.out.println("a : " + a + " b : " + b);
        biConsumer.accept("Functional", "Interface");

        BiConsumer<Integer, Integer> multiply = (a, b) -> System.out.println("Multiply = " + (a * b));
        BiConsumer<Integer, Integer> division =  (a, b) -> System.out.println("Division = " + (a / b));

        multiply.andThen(division).accept(10, 5);

        printNameAndActivities();

    }

    public static void printNameAndActivities() {

        List<Student> students = StudentDataBase.getAllStudents();

        BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out.println("Name : " + name + " and Activities " + activities);
        students.forEach(student -> biConsumer.accept(student.getName(), student.getActivities()));
    }
}
