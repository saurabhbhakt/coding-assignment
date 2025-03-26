package org.quarks.learn.designPattern.creational;

class Person implements Cloneable {
    String name;
    Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Deep clone: Create a new Address object for the clone
        Person clonedPerson = (Person) super.clone();
        clonedPerson.address = (Address) address.clone(); // Clone the address as well
        return clonedPerson;
    }
}

class Address implements Cloneable {
    String city;

    public Address(String city) {
        this.city = city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Shallow clone for Address (since Address has no nested objects)
    }
}

public class DeepCloneExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("New York");
        Person person1 = new Person("John", address);

        // Deep clone of person1
        Person person2 = (Person) person1.clone();



        System.out.println("Original Person Address: " + person1.address.city);
        System.out.println("Cloned Person Address: " + person2.address.city);

        System.out.println(person1.name);
        System.out.println(person2.name);

        // Change the address of the cloned person
        person2.address.city = "Los Angeles";
        person2.name = "Jack";

        System.out.println("Original Person Address after change: " + person1.address.city);
        System.out.println("Cloned Person Address after change: " + person2.address.city);
        System.out.println(person1.name);
        System.out.println(person2.name);
    }
}

