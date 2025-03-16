package com.learn.defaults;

public interface Interface2 extends Interface1{

    default void methodB() {
        System.out.println("Inside methodB() from Interface2");
    }

    @Override
    default void methodA() {
        System.out.println("Inside methodA() from Interface2");
    }
}
