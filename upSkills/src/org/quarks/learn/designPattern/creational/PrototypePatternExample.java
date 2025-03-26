package org.quarks.learn.designPattern.creational;

interface CarPrototype {
    CarPrototype clone();
}

class Car implements CarPrototype {
    private String model;
    private String engine;
    private String color;

    public Car(String model, String engine, String color) {
        this.model = model;
        this.engine = engine;
        this.color = color;
    }

    // Getters and setters for model, engine, and color
    public String getModel() {
        return model;
    }

    public String getEngine() {
        return engine;
    }

    public String getColor() {
        return color;
    }

    // Clone method
    @Override
    public CarPrototype clone() {
        return new Car(this.model, this.engine, this.color);  // Create a new car with the same attributes
    }

    @Override
    public String toString() {
        return "Car [Model=" + model + ", Engine=" + engine + ", Color=" + color + "]";
    }
}

/**
 * CarPrototype is the interface that defines the clone() method, which every prototype will implement.
 * Car is a concrete implementation of the CarPrototype interface. It has a clone() method that returns a new instance of Car with the same attributes as the current one.
 * In the client code, we first create a Car prototype and then clone it using the clone() method. We can then modify the cloned car or use it as it is.
 */

public class PrototypePatternExample {
    public static void main(String[] args) {
        // Create the original car prototype
        CarPrototype originalCar = new Car("Tesla Model S", "Electric", "Red");

        // Clone the original car to create a new car
        CarPrototype clonedCar = originalCar.clone();

        // Display the original and cloned car details
        System.out.println("Original Car: " + originalCar);
        System.out.println("Cloned Car: " + clonedCar);

        // Modify the cloned car and display it
        Car clonedCarModified = (Car) clonedCar;
        clonedCarModified = new Car("Tesla Model X", "Electric", "Blue");
        System.out.println("Modified Cloned Car: " + clonedCarModified);
    }
}
