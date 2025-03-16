package com.learn.defaults;

import java.util.List;

public interface Multiplier {

    int multiply(List<Integer> integerList);

    /**
     * default method which is going to return size of input list.
     * this was never possible before java8
     * This is the handy way of enhancing an interface.
     * This default method can be overridden.
     * @return
     */
    default int size(List<Integer> integerList) {
        System.out.println("Inside Multiplier Interface");
        return integerList.size();
    }

    /**
     * creating static method
     * This static method cannot overridden.
     */
    static boolean isNotEmpty(List<Integer> integerList) {
        return integerList != null && integerList.size()  > 0;
    }
}
