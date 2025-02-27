package com.learn.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamsReduceExample {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(10, 20, 30, 40);
        System.out.println(performMultiplication(numbers));

        Optional<Integer> result1 = perfromMultiplicationWithoutIdentity(numbers);
        System.out.println(result1.isPresent());
        System.out.println(result1.get());

        Optional<Integer> result2 = perfromMultiplicationWithoutIdentity(new ArrayList<>());
        System.out.println(result2.isPresent());

    }

    /**
     * <p>
     *     Preform multiplication of the list.
     * </p>
     * @param integerList
     * @return
     */
    public static int performMultiplication(List<Integer> integerList) {

        return integerList.stream()
                // num1 = 1 num2 = 10 (from Stream) => 1 * 10 result returned
                // num1 = 10, num2 = 20 (from Stream) => 10 * 20 result returned
                // num1 = 200 , num2 = 30 (from Stream) => 200 * 30 result returned
                // num1 = 6000 , num2 = 40 (from Stream) => 24000 result returned
                .reduce(1, (num1 , num2) -> num1 * num2);
    }

    public static Optional<Integer> perfromMultiplicationWithoutIdentity(List<Integer> integerList) {

        return integerList.stream()
                .reduce((num1, num2) -> num1 * num2);
    }
}
