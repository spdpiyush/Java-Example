package com.learn.numericstreams;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamRangesExample {

    public static void main(String[] args) {

        IntStream intStream = IntStream.range(1, 50);

        System.out.println(intStream.count()); // 49 , this stream already closed no operations can be perform further

        /**
         * Prints 1 to 49
         */
        IntStream.range(1, 50)
                .forEach(val -> System.out.print(val + ","));

        System.out.println("\n---------\n");

        /**
         * Prints 1 to 50
         */
        IntStream.rangeClosed(1, 50)
                .forEach(val -> System.out.print(val + ", "));

        /**
         * Long Stream also supports range() and rangeClosed()
         */
        System.out.println("LongStream : " + LongStream.rangeClosed(1, 50).count());

        /**
         * DoubleStream doesn't supports range() and rangeClosed()
         * To get it, we can asDoubleStream() method provided by IntStream and LongStream
         * it will convert all values to Double.
         */
        System.out.println("IntStream : " + IntStream.range(1, 50).asDoubleStream().count());

    }
}
