package com.learn.functionalInterfaces;

import java.util.function.UnaryOperator;

/**
 * <p>
 *     Use UnaryOperator when input and output are of
 *     same type.
 * </p>
 */
public class UnaryOperatorExample {

    static UnaryOperator<String> unaryOperator = String::toUpperCase;

    public static void main(String[] args) {
        System.out.println(unaryOperator.apply("test"));
    }
}
