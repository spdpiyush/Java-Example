package com.learn.parallelstream;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamExample {

    public static void main(String[] args) {
        System.out.println("Sum By Sequential Stream : " + sumBySequentialStream());
        System.out.println("Sum By Parallel Stream : " + sumByParallelStream());

        System.out.println("Performance for Sequential Stream " + checkPerformanceResult(ParallelStreamExample::sumBySequentialStream, 20));
        System.out.println("Performance for Parallel Stream " + checkPerformanceResult(ParallelStreamExample::sumByParallelStream, 20));
    }

    public static int sumBySequentialStream() {
        return IntStream.rangeClosed(1, 100000)
                .sum();
    }

    public static int sumByParallelStream() {
        return IntStream.rangeClosed(1, 100000)
                .parallel()
                .sum();
    }

    /**
     * <p>
     *     Method to check performance for supplier Passed.
     *
     * </p>
     * @param supplier
     * @param numberOfTimes
     * @return
     */
    public static long checkPerformanceResult(Supplier<Integer> supplier, int numberOfTimes) {

        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= numberOfTimes; i++) {
            supplier.get();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
