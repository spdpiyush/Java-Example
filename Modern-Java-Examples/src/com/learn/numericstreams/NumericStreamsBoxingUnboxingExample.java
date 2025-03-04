package com.learn.numericstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamsBoxingUnboxingExample {

    public static void main(String[] args) {

        System.out.println("Boxing : " + boxing());

        System.out.println("Sum by Unboxing : " + unboxing(List.of(1, 2, 3, 4, 5)));
    }

    /**
     * boxing : converting primitive to Wrapper class type.
     * ex: int to Integer
     * boxed() : converts Wrapper Class types
     */
    public static List<Integer> boxing() {
        // IntStream --> Stream<Integer>
        return IntStream.rangeClosed(1, 10)
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * unboxing : converting Wrapper class type to primitive type
     * ex: Integer to int
     * mapToInt() : this is going to return IntStream back
     */
    public static int unboxing(List<Integer> integerList) {
        // integerList gives Wrapper Integer class type values
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
