package com.learn.imperativevsdeclarative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 *     Remove Duplicates from a list of integers.
 * </p>
 */
public class ImperativeVsDeclarativeExample2 {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 4, 5, 5, 5, 2, 4, 1, 5, 7, 8, 9, 9, 10);
        System.out.println(removeDuplicatesUsingImperativeApproach(integerList));
        System.out.println(removeDuplicatesUsingDeclarativeApproach(integerList));
    }

    /**
     * Imperative Approach
     * @param list
     * @return
     */
    private static List<Integer> removeDuplicatesUsingImperativeApproach(List<Integer> list) {
        Set<Integer> uniqueList = new HashSet<>();
        for (Integer num : list) {
            if (!uniqueList.contains(num)) {
                uniqueList.add(num);
            }
        }
        return new ArrayList<>(uniqueList);
    }

    /**
     * Declarative Approach
     * @param list
     * @return
     */
    private static List<Integer> removeDuplicatesUsingDeclarativeApproach(List<Integer> list) {
        return list.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
