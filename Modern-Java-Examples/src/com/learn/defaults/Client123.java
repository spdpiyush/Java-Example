package com.learn.defaults;

/**
 * This Client implements Interface1, Interface2 and Interface3
 *
 * Order of resolving the method calls during runtime.
 *  1 -> Class that implements the interface.
 *  2 -> the sub interface that extends the interface.
 *
 */
public class Client123  implements Interface1, Interface2, Interface3{

    /**
     * The class that overrides the default method takes precedence
     * over any other implementation that we have in other interfaces.
     */
    public void methodA() {
        System.out.println("Inside methodA() from Client123");
    }

    public static void main(String[] args) {
        Client123 client123 = new Client123();

        /**
         * This concept is called multiple inheritance.
         * We are inheriting multiple behaviors from each and every interfaces.
         * This was never possible before Java8
         */
        client123.methodA();
        client123.methodB();
        client123.methodC();


        /**
         * Let's add some more complexity
         * by extending Interface1 in Interface2
         * by extending Interface2 in Interface3
         */
        client123.methodA(); // resolve to the child implementations.
    }
}
