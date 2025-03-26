package org.quarks.learn.java11;

class OuterClass {
    private static String message = "Hello from Nestmates!";

    class InnerClass {
        void printMessage() {
            // Access private member of OuterClass
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.printMessage();
    }
}
