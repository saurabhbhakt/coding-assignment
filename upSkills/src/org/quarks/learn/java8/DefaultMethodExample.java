package org.quarks.learn.java8;

interface MyInterface {
    default void defaultMethod() {
        System.out.println("This is a default method!");
    }

    void abstractMethod();
}

public class DefaultMethodExample implements MyInterface {
    @Override
    public void abstractMethod() {
        System.out.println("Implemented abstract method");
    }

    public static void main(String[] args) {
        DefaultMethodExample example = new DefaultMethodExample();
        example.defaultMethod();  // Calling default method from interface
        example.abstractMethod(); // Calling implemented method
    }
}

