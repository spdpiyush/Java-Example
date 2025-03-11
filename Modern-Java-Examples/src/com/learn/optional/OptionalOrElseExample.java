package com.learn.optional;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.Optional;

public class OptionalOrElseExample {

    public static void main(String[] args) {

        System.out.println("Optional orElse() : " + optionalOrElse());

        System.out.println("Optional orElseGet() : " + optionalOrElseGet());

        System.out.println("Optional orElseThrow() : " + optionalOrElseThrow());
    }

    /**
     * <p>
     *     orElse(T) : it accepts the actual value
     *     If a value is present, returns the value, otherwise returns
     *     other value passed.
     * </p>
     * @return
     */
    public static String optionalOrElse() {

        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());

        /**
         * Optional<Student> studentOptional = Optional.ofNullable(null); // it return Optional.empty()
         * it's going try to map the student object and try to get Name. but since it is empty,
         * it won't be able to execute map, and execute the orElse and return John.
         */
        return studentOptional.map(Student::getName).orElse("John");
    }

    /**
     * <p>
     *     orElseGet(Supplier) : it's going to accept a supplier.
     *     If a value is present, returns the value, otherwise returns the result
     *     produced by the supplying function.
     * </p>
     * @return
     */
    public static String optionalOrElseGet() {

        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        return studentOptional.map(Student::getName).orElseGet(() -> "Default");
    }

    /**
     * @apiNote
     * There are 2 different versions of orElseThrow().
     * <ul>
     *  <li>orElseThrow() : it throws NoSuchElementException if no value is present </li>
     *  <li>orElseThrow(Supplier<? extends X> exceptionSupplier) : it accepts exceptionSupplier the
     *        supplying function that produces an exception to be thrown</li>
     * </ul>
     *
     */
    public static String optionalOrElseThrow() {
        Optional<Student> studentOptional = Optional.ofNullable(null);
        return studentOptional.map(Student::getName)
                .orElseThrow(() -> new RuntimeException("No Data Found"));
    }
}
