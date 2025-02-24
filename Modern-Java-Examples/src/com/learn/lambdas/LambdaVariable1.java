package com.learn.lambdas;

import java.util.function.Consumer;

public class LambdaVariable1 {

    private static int num = 10;

    public static void main(String[] args) {

        int  i = 10; // local Variable

        /**
         * we can't use the same variable which is
         * already defined in this method scope.
         */
        Consumer<Integer> consumer1 = (i1) -> {
            System.out.println(i1);
        };


        int value = 5;
        /**
         * we are not allowed to modify any local variables
         * that is being referenced in lambda scope.
         */
        Consumer<Integer> consumer2 = (i1) -> {
            //i = 10;  ( Not allowed )
            System.out.println(i1 + value);
        };

        // value = 5; even we can't do this. since it is referenced in lambda scope.


        /**
         * For Instance Variables or Class Variables,
         * there is no restriction.
         */
        Consumer<Integer> consumer3 = (i1) -> {
            num = 5;
            System.out.println(i1 + num);
        };

        num = 2;
    }
}
