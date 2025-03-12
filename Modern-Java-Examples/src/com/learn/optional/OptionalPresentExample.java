package com.learn.optional;

import java.util.Optional;

public class OptionalPresentExample {

    public static void main(String[] args) {



        Optional<String> optional1 = Optional.ofNullable("java");
        Optional<String> optional2 = Optional.ofNullable(null);

        // isPresent() : it checks whether this optional object has some value in it or not.
        System.out.println(optional1.isPresent()); // true
        System.out.println(optional2.isPresent()); // false


        /**
         *
         * ifPresent() : If a value is present, performs the given action with the value,
         * otherwise does nothing.
         *
         * ifPresent(Consumer) : it takes input as Consumer.
         */
        optional1.ifPresent(s -> System.out.println(s.toUpperCase()));
        optional2.ifPresent(s -> System.out.println(s.toUpperCase()));


    }
}
