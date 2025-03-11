package com.learn.optional;

import java.util.Optional;

public class OptionalOfEmptyNullableExample {

    public static void main(String[] args) {

        System.out.println("Optional.ofNullable() : " + ofNullableExample());
        System.out.println("Optional.ofNullable() : " + ofNullableExample().get()); // to get actual value stored inside optional.

        System.out.println("Optional.of() :" + ofExample());

        System.out.println("Optional.empty() : " + emptyExample());
    }

    /**
     * <p>
     *     if we are not certain the value is going to be valid String all the time,
     *     then we would use <code>Optional.ofNullable()</code>
     * </p>
     * @return
     */
    public static Optional<String> ofNullableExample() {

        // "java" string is wrapped inside this Optional
        Optional<String> stringOptional = Optional.ofNullable("java");
        // if we pass value as null, then it returns Optional.empty();
        return stringOptional;
    }


    /**
     * <p>
     *     <code>of()</code>, always expects us to send valid value as input. otherwise,
     * @throws NullPointerException if value is {@code null}
     * </p>
     * @return
     */
    public static Optional<String> ofExample() {

        Optional<String> stringOptional = Optional.of("java");
        // if we pass values as null, then it throws Null Pointer Exception.
        return stringOptional;
    }

    /**
     * Returns an empty {@code Optional} instance of type T.  No value is present for this
     * {@code Optional}.
     * @return
     */
    public static Optional<String> emptyExample() {
        return Optional.empty();
    }
}
