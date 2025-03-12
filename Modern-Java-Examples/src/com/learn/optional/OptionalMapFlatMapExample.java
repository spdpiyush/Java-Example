package com.learn.optional;

import com.learn.data.Bike;
import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.Optional;

public class OptionalMapFlatMapExample {

    public static void main(String[] args) {

        optionalFilterExample();
        optionalMapExample();
        optionalFlatMapExample();
    }

    /**
     * If a value is present, and the value matches the given predicate,
     * returns an {@code Optional} describing the value, otherwise returns an
     * empty {@code Optional}.
     * filter
     */
    public static void optionalFilterExample() {

        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        // apply filter before we get actual value.
        studentOptional
                .filter(student -> student.getGpa() >= 3.9)
                .ifPresent(System.out::println);

    }

    /**
     * If a value is present, returns an {@code Optional} describing (as if by
     * the result of applying the given mapping function to
     * the value, otherwise returns an empty {@code Optional}.
     *
     * If the mapping function returns a {@code null} result then this method
     * returns an empty {@code Optional}.
     */
    public static void optionalMapExample() {

        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        if (studentOptional.isPresent()) {
            Optional<String> stringOptional = studentOptional
                    .filter(student -> student.getGpa() >= 3.9)
                    .map(Student::getName);
            System.out.println(stringOptional);

        }
    }

    /**
     * To get Optional Object inside an Optional object, the only way to get it
     * is by using flatMap()
     *
     * In Optional Context, flatMap() is used to get the actual value of the Optional object inside
     * another Optional object.
     */
    public static void optionalFlatMapExample() {

        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());

        Optional<String> stringOptional = studentOptional
                .filter(student -> student.getGpa() >= 3.9) // Optional<Student <Optional<Bike> >
                .flatMap(Student::getBike) // Optional<Bike>
                .map(Bike::getName);

        System.out.println(stringOptional);
    }
}
