package org.quarks.learn.designPattern.creational;

class Employee implements Cloneable {
    String name;
    AddressRef address;

    public Employee(String name, AddressRef address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow clone
    }
}

class AddressRef {
    String city;

    public AddressRef(String city) {
        this.city = city;
    }
}

public class ShallowCloneExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        AddressRef address = new AddressRef("New York");
        Employee person1 = new Employee("John", address);

        // Shallow clone of person1
        Employee person2 = (Employee) person1.clone();

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
