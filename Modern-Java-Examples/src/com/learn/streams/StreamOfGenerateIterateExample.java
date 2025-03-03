package com.learn.streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamOfGenerateIterateExample {

    public static void main(String[] args) {

        /**
         * Create Stream using of() method.
         */
        Stream<String> stringStream = Stream.of("John", "Doe", "Mark", "Vince");
        stringStream.forEach(System.out::println);

        /**
         * It will iterate infinite times.
         * 1: initial Value
         */
        Stream.iterate(1, x -> x * 2)
                .forEach(System.out::println);

        // but we can use limit to limit the no of values it can pick from stream
        Stream.iterate(1, x -> x * 2)
                .limit(10)
                .forEach(System.out::println);

        Supplier<Integer> integerSupplier = new Random()::nextInt; // gives random values
        /**
         * <p>
         *     generate() also generates infinite streams, but we can limit using limit() operation.
         * </p>
         */
        Stream.generate(integerSupplier)
                .limit(5)
                .forEach(System.out::println);
    }
}
