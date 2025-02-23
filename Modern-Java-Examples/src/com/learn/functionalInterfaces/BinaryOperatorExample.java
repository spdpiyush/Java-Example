package com.learn.functionalInterfaces;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * <p>
 *     BinaryOperator extends BiFunction Functional Interface.
 *     Use BinaryOperator, when inputs and output are of same type.
 * </p>
 */
public class BinaryOperatorExample {

    static Comparator<Integer> comparator = (a, b) ->  a.compareTo(b);


    public static void main(String[] args) {

        BinaryOperator<Integer> binaryOperator = (num1, num2) -> num1 * num2;
        System.out.println(binaryOperator.apply(10, 20));

        BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
        System.out.println("Maximum = " + maxBy.apply(10, 20));

        BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);
        System.out.println("Minimum = " + minBy.apply(10, 20));
    }
}
