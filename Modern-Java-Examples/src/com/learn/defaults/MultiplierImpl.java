package com.learn.defaults;

import java.util.List;

public class MultiplierImpl implements Multiplier {

    @Override
    public int multiply(List<Integer> integerList) {
        return integerList.stream()
                .reduce(1, (num1, num2) -> num1 * num2);
    }

    @Override
    public int size(List<Integer> integerList) {
        System.out.println("Inside MultiplierImpl class");
        return Multiplier.super.size(integerList);
    }
}
