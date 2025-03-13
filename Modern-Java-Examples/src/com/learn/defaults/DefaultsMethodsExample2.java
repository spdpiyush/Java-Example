package com.learn.defaults;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class DefaultsMethodsExample2 {

    static Consumer<Student> studentConsumer = System.out::println;
    static Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
    static Comparator<Student> gpaComparator = Comparator.comparingDouble(Student::getGpa);
    static Comparator<Student> gradeComparator = Comparator.comparingInt(Student::getGradeLevel);


    public static void main(String[] args) {

        List<Student> studentList = StudentDataBase.getAllStudents();
        System.out.println("Before Sorting");
        studentList.forEach(studentConsumer);

        sortByName(studentList);

        sortByGpa(studentList);

        comparatorChain(studentList);

    }

    public static void sortByName(List<Student> studentList) {
        System.out.println("Sorting By using name");
        studentList.sort(nameComparator);
        studentList.forEach(studentConsumer);
    }

    public static void sortByGpa(List<Student> studentList) {
        System.out.println("Sorting By using GPA");
        studentList.sort(gpaComparator);
        studentList.forEach(studentConsumer);
    }

    /**
     * thenComparing(): Comparator chaining
     * Chaining 2 different comparator operations and then consolidate the result
     */
    public static void comparatorChain(List<Student> studentList) {

        System.out.println("Comparator Chaining");

        // first sort by Grade
        // So in Each grade, sort the result by their name.
        studentList.sort(gradeComparator.thenComparing(nameComparator));
        studentList.forEach(studentConsumer);
    }
}
