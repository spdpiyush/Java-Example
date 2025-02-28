package com.learn.streams;

import java.util.List;
import java.util.Optional;

public class StreamsLimitSkipExample {

    public static void main(String[] args) {

        List<Integer> integerList = List.of(10, 20, 30, 40, 50);

        Optional<Integer> sum = sumWithLimit(integerList);
        if (sum.isPresent()) {
            System.out.println("Limit Sum : " + sum.get());
        }

        Optional<Integer> sumWithSkip = sumWithSkip(integerList);
        if (sumWithSkip.isPresent()) {
            System.out.println("Skip Sum : " + sumWithSkip.get());
        }
    }

    public static Optional<Integer> sumWithLimit(List<Integer> integerList) {
        return integerList.stream()
                .limit(2)
                // only 10 and 20 will be passed to reduce function
                .reduce(Integer::sum);
    }

    public static Optional<Integer> sumWithSkip(List<Integer> integerList) {
        return integerList.stream()
                // first 3 numbers are skipped
                .skip(3)
                //it passes only 40 and 50.
                .reduce(Integer::sum);
    }


}
