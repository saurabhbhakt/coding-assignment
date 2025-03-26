package org.quarks.learn.java17;

import java.util.random.RandomGenerator;

public class RandomGeneratorExample {
    public static void main(String[] args) {
        RandomGenerator generator = RandomGenerator.of("LXM");
        int randomValue = generator.nextInt(1, 100); // Random number between 1 and 100
        System.out.println(randomValue);
    }
}

