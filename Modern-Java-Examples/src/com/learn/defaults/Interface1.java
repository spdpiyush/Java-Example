package com.learn.defaults;

public interface Interface1 {

    default void methodA() {
        System.out.println("Inside methodA() from Interface1");
    }
}
