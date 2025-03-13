package com.learn.defaults;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultsMethodsExample {

    public static void main(String[] args) {

        /**
         * Sort the list of names in alphabetical order.
         */
        List<String> stringList = StudentDataBase.getAllStudents().stream().map(Student::getName).collect(Collectors.toList());

        /**
         * Prior Java8, by using Collections class.
         */
        Collections.sort(stringList); // sort the input in alphabetical order
        System.out.println("Sorted list using Collections.sort() : " + stringList);

        /**
         * Java8 approach,
         * In Java8, the List interface has a default method sort
         * And this sort method, takes an input called Comparator.
         * By this default methods, it helps to add new functionalities into the interfaces so that this interface
         * can evolve according to the new technology and new use cases.
         */
        List<String> stringList1 = StudentDataBase.getAllStudents().stream().map(Student::getName).collect(Collectors.toList());
        stringList1.sort(Comparator.naturalOrder());
        System.out.println("Sorted list using List.sort() : " + stringList1);
    }
}
