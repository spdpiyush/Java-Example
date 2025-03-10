package com.learn.streams;

import java.util.List;
import java.util.Optional;

public class StreamsMinMaxExample {

    public static void main(String[] args) {

        List<Integer> integerList = List.of(10, 20, 5 , 15, 9, 4);


        System.out.println(findMaxValue(integerList));

        Optional<Integer> maxValueOptional = findMaxValueOptional(integerList);
        if (maxValueOptional.isPresent()) {
            System.out.println("Max with Optional : " + maxValueOptional.get());
        }else {
            System.out.println("Input list is empty.");
        }

        System.out.println("Minimum value = " + findMinValue(integerList));
        Optional<Integer> minValueOptional = findMinValueOptional(integerList);
        if (minValueOptional.isPresent()) {
            System.out.println("Min value with Optional : " + minValueOptional.get());
        }else {
            System.out.println("Input list is empty.");
        }
    }

    /**
     * this method is not correct if we pass empty List, it returns the default value as max.
     * @param integerList
     * @return
     */
    public static int findMaxValue(List<Integer> integerList) {
        return integerList.stream()
                // num1 variable holds the max value for each element in the iteration.
                .reduce(Integer.MIN_VALUE, (num1, num2) -> num1 > num2 ? num1 : num2);
    }

    /**
     * this works perfectly fine for empty list as well
     * for emptyList it returns Optional.empty()
     * @param integerList
     * @return
     */
    public static Optional<Integer> findMaxValueOptional(List<Integer> integerList) {
        return integerList.stream()
                .reduce(Integer::max);
    }

    /**
     * this method is not correct, if we pass empty List, it returns the default value as min.
     * @param integerList
     * @return
     */
    public static int findMinValue(List<Integer> integerList) {
        return integerList.stream()
                .reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y);
    }

    /**
     * Finding min with Optional
     * @param integerList
     * @return
     */
    public static Optional<Integer> findMinValueOptional(List<Integer> integerList) {
        return integerList.stream()
                .reduce(Integer::min);
    }
}
