package com.learn.streams;

import java.util.ArrayList;
import java.util.stream.Stream;

public class CollectionVsStream {

    public static void main(String[] args) {

        /**
         * <p>
         *     In Collection, we can add, remove or modify the Values.
         * </p>
         */
        ArrayList<String> names = new ArrayList<>();
        names.add("adam");
        names.add("jim");
        names.add("jenny");

        names.remove(0);
        System.out.println(names);

        /**
         * <p>
         *     But Stream, doesn't allow us to add, modify or delete elements once it is created.
         * </p>
         */

        /**
         * <p>
         *     Collections can be traversed "n" times.
         * </p>
         */
        for (String name : names) {
            System.out.println(name);
        }

        for (String name : names) {
            System.out.println(name);
        }

        /**
         * Streams can be traversed only once
         */
        Stream<String> namesStream = names.stream();

        namesStream.forEach(System.out::println);
        namesStream.forEach(System.out::println); // it throws an Exception. stream has already been operated upon or closed.

    }
}
