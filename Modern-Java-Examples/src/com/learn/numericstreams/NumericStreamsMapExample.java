package com.learn.numericstreams;

import com.learn.data.ToDoNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamsMapExample {

    public static void main(String[] args) {

        System.out.println("mapToObj : " + mapToObj());
        System.out.println("mapToLong : " + mapToLong());
        System.out.println("mapToDouble : " + mapToDouble());
    }


    /**
     * <p>
     *     mapToObj() : it takes IntFunction as input and (IntFunction take int value as input )
     *     Here converting int to an Object.
     * </p>
     */
    public static List<String> mapToObj() {
        return IntStream.rangeClosed(1, 5)
                .mapToObj(ToDoNumber::addNumberToList)
                .collect(Collectors.toList());
    }

    /**
     * <p>
     *     mapToLong() : it takes IntToLongFunction as input
     *     and IntToLongFunction Represents a function that accepts an int-valued argument and produces a long-valued result.
     * </p>
     * @return
     */
    public static long mapToLong() {
        return IntStream.rangeClosed(1, 5)
                //Here it converts IntStream to LongStream
                // and i value passed from IntStream
                .mapToLong(i -> i)
                .sum();
    }

    /**
     * <p>
     *     mapToDouble() : it takes IntToDoubleFunction as input
     *     and IntToDoubleFunction Represents a function that accepts an int-valued argument and produces a double-valued result.
     * </p>
     */
    public static double mapToDouble() {
        return IntStream.rangeClosed(1, 5)
                // Here it converts IntStream to DoubleStream
                // and i value passed from IntStream
                .mapToDouble(i -> i)
                .sum();
    }
}
