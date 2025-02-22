package com.learn.functionalInterfaces;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {

    private Predicate<Student> gradeLevelPredicate = (student) -> student.getGradeLevel() >= 3;
    private Predicate<Student> gpaPredicate = (student) -> student.getGpa() >= 3.9;

    private BiConsumer<String, List<String>> biConsumer = (a, b) -> System.out.println("Name : " + a +" and Activities :" + b);

    private Consumer<Student> studentConsumer = (student) -> {
        if (gradeLevelPredicate.and(gpaPredicate).test(student)) {
            biConsumer.accept(student.getName(), student.getActivities());
        }
    };

    public void printNameAndActivities() {
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(studentConsumer);
    }

    public static void main(String[] args) {

        PredicateAndConsumerExample example = new PredicateAndConsumerExample();
        example.printNameAndActivities();
    }
}
