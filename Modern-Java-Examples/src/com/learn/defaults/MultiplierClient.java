package com.learn.defaults;

import java.util.Arrays;
import java.util.List;

public class MultiplierClient {

    public static void main(String[] args) {

        Multiplier multiplier = new MultiplierImpl();
        List<Integer> integerList = Arrays.asList(1, 3, 5);

        System.out.println("Result is : " + multiplier.multiply(integerList));
        System.out.println("Default Method size : " + multiplier.size(integerList));

        // isNotEmpty is a static method it can be accessed using the class
        System.out.println("static method isNotEmpty : " + Multiplier.isNotEmpty(integerList));

    }
}
