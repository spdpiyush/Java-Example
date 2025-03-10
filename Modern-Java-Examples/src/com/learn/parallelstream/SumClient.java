package com.learn.parallelstream;

import java.util.stream.IntStream;

/**
 * <p>
 *     If we have any Mutating Variable, then we should
 *     not use parallel streams.
 * </p>
 */
public class SumClient {

    public static void main(String[] args) {

        Sum sum = new Sum();

        IntStream.rangeClosed(1, 1000)
                //passes value 1, 2, 3, 4 ...... 1000
                .forEach(sum::performSum);
        System.out.println(sum.getTotal());

        /**
         * <p>
         *     everytime parallel stream giving us a different result
         *     Here, we are concurrently accessing the "total" variable and updating this variable.
         *     That's  one of the reason why we get different results, when we run the program everytime.
         *     Parallel() splits the data input into multiple parts and the concurrently updating the variable.
         * </p>
         */
        Sum sum1 = new Sum();
        IntStream.rangeClosed(1, 1000)
                .parallel()
                .forEach(sum1::performSum);
        System.out.println(sum1.getTotal());

    }
}
