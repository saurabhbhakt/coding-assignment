package org.quarks.learn.java17;

// Sealed class with permitted subclasses
sealed class Animal permits Dog, Cat {
    public void sound() {
        System.out.println("Animal sound");
    }
}
 final class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Bark");
    }
}

final class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Meow");
    }
}

