package com.learn.functionalInterfaces;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {

        Supplier<Student> supplier = () -> {
            return StudentDataBase.getAllStudents().get(0);
        };

        System.out.println(supplier.get());

        Supplier<List<Student>> supplier1 = StudentDataBase::getAllStudents;
        System.out.println(supplier1.get());
    }
}
