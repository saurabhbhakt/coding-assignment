package org.quarks.learn.collection.comparing;

import java.util.*;

class User {
    String name;
    int age;

    // Constructor
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", 30));
        users.add(new User("Bob", 25));
        users.add(new User("Charlie", 35));

        // Comparator for sorting by name (alphabetically)
        Comparator<User> nameComparator = new Comparator<User>() {
            @Override
            public int compare(User p1, User p2) {
                return p1.name.compareTo(p2.name);  // Sort by name alphabetically
            }
        };

        // Sorting using Comparator (sorting by name)
        Collections.sort(users, nameComparator);

        System.out.println("Sorted by name (using Comparator):");
        for (User person : users) {
            System.out.println(person);
        }

        // Comparator for sorting by age (descending order)
        Comparator<User> ageComparator = new Comparator<User>() {
            @Override
            public int compare(User p1, User p2) {
                return Integer.compare(p2.age, p1.age);  // Sort by age in descending order
            }
        };

        // Sorting using Comparator (sorting by age in descending order)
        Collections.sort(users, ageComparator);

        System.out.println("\nSorted by age (descending, using Comparator):");
        for (User person : users) {
            System.out.println(person);
        }
    }
}

