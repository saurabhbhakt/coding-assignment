package org.quarks.learn.java8;

@FunctionalInterface
interface MyFunctionalInterface {
    void myMethod();
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        MyFunctionalInterface obj = () -> System.out.println("Functional Interface using Lambda!");
        obj.myMethod();
    }
}

