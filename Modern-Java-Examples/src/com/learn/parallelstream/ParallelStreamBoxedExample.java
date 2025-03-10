package com.learn.parallelstream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <p>
 *     It is always recommended to check the performance before
 *     going to the assumption that parallel stream is going to perform better.
 * </p>
 */
public class ParallelStreamBoxedExample {

    public static void main(String[] args) {

        /**
         * This are not primitive integers.
         * These are Wrapper integer Objects.
         */
        List<Integer> integerList = IntStream.rangeClosed(1, 10000).boxed().collect(Collectors.toList());
        sequentialSum(integerList);
        parallelSum(integerList);
    }


    /**
     * <p>
     *     Performing the Sequential Stream on the input.
     * </p>
     */
    public static int sequentialSum(List<Integer> integerList) {
        long startTime = System.currentTimeMillis();
        int sum =  integerList
                .stream()
                .reduce(0, Integer::sum);
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential Stream Time Take : " + (endTime - startTime));
        return sum;
    }

    /**
     * <p>
     *     Performing the parallel Stream on the input.
     *     here, it need to convert unboxing from Integer to int for each and every value.
     * </p>
     */
    public static int parallelSum(List<Integer> integerList) {
        long startTime = System.currentTimeMillis();
        int sum = integerList
                .parallelStream()
                .reduce(0, Integer::sum); // here effort is required to perform Unboxing.
        long endTime = System.currentTimeMillis();
        System.out.println("Parallel Stream Time Taken : " + (endTime - startTime));
        return sum;
    }
}
