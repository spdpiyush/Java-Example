package com.learn.methodreference;

import java.util.function.Function;

public class FunctionMethodReferenceExample {

    static Function<String, String> toUpperCaseMethodReference = String::toUpperCase;

    public static void main(String[] args) {

        System.out.println(toUpperCaseMethodReference.apply("java8"));
    }
}
