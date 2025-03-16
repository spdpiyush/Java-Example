package com.learn.defaults;

public interface Interface4 {

    default void methodA() {
        System.out.println("Inside methodA() from Interface4");
    }
}
