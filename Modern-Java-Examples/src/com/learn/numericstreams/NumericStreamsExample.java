package com.learn.numericstreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NumericStreamsExample {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(sumOfN(integerList));

        System.out.println("sum using IntStream : " + sumOfNUsingIntStream());
    }

    /**
     * here we are passing List<Integer>, Integer is a wrapper class for int primitive datatype
     * Basically under the hood it performs the unboxing operations to convert Integer to int.
     * @param integerList
     * @return
     */
    public static int sumOfN(List<Integer> integerList) {
        return integerList.stream()
                .reduce(0, Integer::sum); // converting Integer to int.
    }

    /**
     * to avoid this unboxing operation, we can use IntStream
     */
    public static int sumOfNUsingIntStream() {
        return IntStream.rangeClosed(1, 6)
                .sum();
    }
}
