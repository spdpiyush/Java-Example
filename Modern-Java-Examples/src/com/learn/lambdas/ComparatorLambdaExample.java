package com.learn.lambdas;

import java.util.Comparator;

public class ComparatorLambdaExample {

    public static void main(String[] args) {

        /**
         * Before Java8
         */
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println("Without Using Lambdas : " + comparator1.compare(10, 20));

        /**
         * By Using Java8 Lambdas
         */
        Comparator<Integer> comparator2 = (num1, num2) -> num1.compareTo(num2);
        System.out.println("By Using Lambdas : " + comparator2.compare(10, 20));
    }
}
