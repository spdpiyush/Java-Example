package com.learn.defaults;

/**
 * This client going to implements interface 1 and interface4
 * Here Interface1 and Interface4 have similar methods ( methodA ).
 * it gives some compilation issue, bcoz of similar signature of methodA in both interfaces.
 * So, the actual expectation is these kind of scenarios is that we have to override that method
 * in actual implementation class, only way to resolve this kind of conflicts.
 */
public class Client14 implements Interface1, Interface4{

    public static void main(String[] args) {
        Client14 client14 = new Client14();
        client14.methodA();
    }

    @Override
    public void methodA() {
        System.out.println("Inside methodA() from Client14");
    }
}
