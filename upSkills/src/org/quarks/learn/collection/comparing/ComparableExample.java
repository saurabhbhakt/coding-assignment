package org.quarks.learn.collection.comparing;

import java.util.*;

class Person implements Comparable<Person> {
    String name;
    int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Implement the compareTo method to define the natural ordering by age
    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);  // Sort by age (ascending order)
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        // Sorting using Comparable (natural ordering by age)
        Collections.sort(people);

        System.out.println("Sorted by age (using Comparable):");
        for (Person person : people) {
            System.out.println(person);
        }
    }
}

