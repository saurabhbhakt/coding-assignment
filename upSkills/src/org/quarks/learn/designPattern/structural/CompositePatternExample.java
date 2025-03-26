package org.quarks.learn.designPattern.structural;
import java.util.ArrayList;
import java.util.List;

interface Graphic {
    void draw();  // Common method for both Leaf and Composite
}

class C_Circle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class R_Rectangle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}



class ShapeGroup implements Graphic {
    private List<Graphic> graphics = new ArrayList<>();

    // Add a graphic (either Leaf or Composite)
    public void add(Graphic graphic) {
        graphics.add(graphic);
    }

    // Remove a graphic (either Leaf or Composite)
    public void remove(Graphic graphic) {
        graphics.remove(graphic);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a ShapeGroup:");
        for (Graphic graphic : graphics) {
            graphic.draw();  // Delegate drawing to the contained objects
        }
    }
}

/**
 * Graphic: The Graphic interface defines the common method draw(), which is implemented by both the Leaf and Composite classes.
 * Circle and Rectangle: These are concrete leaf classes. They represent the simple objects in the hierarchy that do not contain other objects.
 * ShapeGroup: This is the composite class that can contain a collection of Graphic objects (either other composites or leaf objects). It implements the draw() method by iterating over its collection and invoking the draw() method on each contained object.
 * The client code demonstrates how individual shapes can be grouped into composite shapes and how the draw() method can be invoked on both individual shapes and composite groups.
 */

public class CompositePatternExample {
    public static void main(String[] args) {
        // Create individual shapes (Leaf objects)
        Graphic circle = new C_Circle();
        Graphic rectangle = new R_Rectangle();

        // Create a group of shapes (Composite object)
        ShapeGroup group1 = new ShapeGroup();
        group1.add(circle);
        group1.add(rectangle);

        // Create another group and add group1 into it
        ShapeGroup group2 = new ShapeGroup();
        group2.add(group1);
        group2.add(new C_Circle());  // Adding another circle to group2

        // Draw the shapes
        System.out.println("Drawing group1:");
        group1.draw();  // This will draw the circle and the rectangle

        System.out.println("\nDrawing group2:");
        group2.draw();  // This will draw group1 and the additional circle
    }
}




