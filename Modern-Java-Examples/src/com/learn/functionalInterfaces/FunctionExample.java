package com.learn.functionalInterfaces;

import java.util.function.Function;

public class FunctionExample {

    static Function<String, String> function1 = (str) -> str.toUpperCase();
    static Function<String, String> function2 = (str) -> str.concat(" default");

    public static void main(String[] args) {

        System.out.println(performConcat("test"));

        System.out.println(function1.andThen(function2).apply("test"));

        /**
         * Here function2 is performed first and it's result is passed to function1.
         */
        System.out.println(function1.compose(function2).apply("test"));


    }

    public static String performConcat(String str) {
        return function2.apply(str);
    }

}
