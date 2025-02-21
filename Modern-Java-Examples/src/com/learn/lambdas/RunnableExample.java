package com.learn.lambdas;

public class RunnableExample {

    public static void main(String[] args) {

        /**
         * Before Java8
         */
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("By Using Anonymous Class Way: Runnable1");
            }
        };
        new Thread(runnable1).start();

        /**
         * Java 8
         * By Using Lambdas
         */
        Runnable runnable2 = () -> System.out.print("By Using Lambdas Way: Runnable2");
        new Thread(runnable2).start();
    }
}
