package com.learn.functionalInterfaces;

import java.util.function.Predicate;

public class PredicateExample {

    /**
     * Predicate accepting Integer and
     * Check Whether Passed integer is Even or not.
     */
    static Predicate<Integer> evenNumberPredicate = (num) -> num % 2 == 0;
    static Predicate<Integer> predicate1 = (num) -> num % 5 == 0;

    public static void main(String[] args) {

        System.out.println(evenNumberPredicate.test(10));


        predicateWithAnd();
        predicateWithOr();
        predicateWithNegate();

    }

    public static void predicateWithAnd() {
        System.out.println(evenNumberPredicate.and(predicate1).test(10));
    }

    public static void predicateWithOr() {
        System.out.println(evenNumberPredicate.or(predicate1).test(12));
    }

    public static void predicateWithNegate() {
        /**
         * negate() -> reverse the result of the Predicate
         */
        System.out.println(evenNumberPredicate.negate().test(9));
    }
}
