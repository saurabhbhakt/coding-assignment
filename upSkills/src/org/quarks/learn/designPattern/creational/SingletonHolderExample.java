package org.quarks.learn.designPattern.creational;

class SingletonH {
    // Private constructor to prevent instantiation
    private SingletonH() {
        // Private constructor prevents instantiation from outside
    }

    // Static inner class that holds the instance of Singleton
    private static class SingletonHolder {
        // Instance of Singleton is created when this class is loaded
        private static final SingletonH INSTANCE = new SingletonH();
    }

    // Public method to provide access to the single instance
    public static SingletonH getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

public class SingletonHolderExample {
    public static void main(String[] args) {
        // Get the instance of Singleton
        SingletonH singleton1 = SingletonH.getInstance();
        SingletonH singleton2 = SingletonH.getInstance();
        System.out.println(singleton1 == singleton2);  // true, both are the same instance
    }
}

