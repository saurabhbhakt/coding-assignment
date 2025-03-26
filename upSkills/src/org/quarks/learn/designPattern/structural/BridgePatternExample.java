package org.quarks.learn.designPattern.structural;

interface Color {
    void applyColor();
}

class Red implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying red color");
    }
}

class Green implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying green color");
    }
}

abstract class Shape {
    protected Color color;  // Reference to the Color implementor

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void draw();
}

class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.print("Drawing a circle with ");
        color.applyColor();  // Delegating color application to the Color implementor
    }
}

class Rectangle extends Shape {
    public Rectangle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.print("Drawing a rectangle with ");
        color.applyColor();  // Delegating color application to the Color implementor
    }
}

/**
 * Color: The Color interface represents the implementation part of the Bridge pattern. It has a method applyColor(), which is implemented by different color classes like Red and Green.
 * Shape: The Shape class is the abstraction. It holds a reference to the Color interface and delegates the responsibility of applying the color to the color object.
 * Circle and Rectangle: These are concrete abstractions of the Shape class. They implement the draw() method and delegate the color application to the Color object.
 * Red and Green: These are concrete implementations of the Color interface. They define how the color is applied.
 * The client code creates instances of shapes and colors and then uses them together.
 */

public class BridgePatternExample {
    public static void main(String[] args) {
        // Create color implementations
        Color red = new Red();
        Color green = new Green();

        // Create shapes with different colors
        Shape circle = new Circle(red);  // Red circle
        Shape rectangle = new Rectangle(green);  // Green rectangle

        // Draw the shapes
        circle.draw();  // Output: Drawing a circle with Applying red color
        rectangle.draw();  // Output: Drawing a rectangle with Applying green color
    }
}

