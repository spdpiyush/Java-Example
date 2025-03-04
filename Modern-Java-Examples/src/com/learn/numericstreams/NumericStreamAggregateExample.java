package com.learn.numericstreams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * <p>
 *     Aggregate Functions
 * </p>
 */
public class NumericStreamAggregateExample {

    public static void main(String[] args) {

        int sum = IntStream.rangeClosed(1, 50).sum(); // sum of 1 to 50.
        System.out.println("sum : " + sum);

        /**
         * max : return OptionalInt
         * if stream is empty in that case it return this optional object with empty value.
         */
        OptionalInt maxOptionalInt = IntStream.rangeClosed(1, 50).max();
        if (maxOptionalInt.isPresent()) {
            System.out.println("Maximum : " + maxOptionalInt.getAsInt());
        }

        OptionalInt minOptionalInt = IntStream.rangeClosed(1, 50).min();
        if (minOptionalInt.isPresent()) {
            System.out.println("Minimum " + minOptionalInt.getAsInt());
        }

        /**
         * average() returns OptionalDouble
         */
        OptionalDouble averageOptionalDouble = IntStream.rangeClosed(1, 50).average();
        if (averageOptionalDouble.isPresent()) {
            System.out.println(averageOptionalDouble.getAsDouble());
        }
    }
}
