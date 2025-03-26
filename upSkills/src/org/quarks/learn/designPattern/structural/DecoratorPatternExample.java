package org.quarks.learn.designPattern.structural;

interface Coffee {
    String getDescription();  // Returns the description of the coffee
    double cost();            // Returns the cost of the coffee
}

class SimpleCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double cost() {
        return 5.0;  // The cost of a simple coffee
    }
}


abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;  // The coffee object to be decorated

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();  // Delegate to the wrapped coffee
    }

    @Override
    public double cost() {
        return coffee.cost();  // Delegate to the wrapped coffee
    }
}

class Milk extends CoffeeDecorator {

    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";  // Add milk to the description
    }

    @Override
    public double cost() {
        return coffee.cost() + 1.5;  // Add the cost of milk
    }
}

class Sugar extends CoffeeDecorator {

    public Sugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";  // Add sugar to the description
    }

    @Override
    public double cost() {
        return coffee.cost() + 0.5;  // Add the cost of sugar
    }
}

class WhippedCream extends CoffeeDecorator {

    public WhippedCream(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Whipped Cream";  // Add whipped cream to the description
    }

    @Override
    public double cost() {
        return coffee.cost() + 2.0;  // Add the cost of whipped cream
    }
}

/**
 * Coffee: This is the base interface for coffee-related objects. It defines two methods: getDescription() for the description of the coffee and cost() for the price of the coffee.
 * SimpleCoffee: A concrete class that implements the Coffee interface. This represents a basic coffee with no decorations.
 * CoffeeDecorator: An abstract decorator class that implements the Coffee interface and holds a reference to a Coffee object. It delegates the getDescription() and cost() methods to the wrapped Coffee object.
 * Milk, Sugar, WhippedCream: Concrete decorators that add extra functionality to the SimpleCoffee by adding their own description and cost.
 * The client code demonstrates how you can create a basic coffee and then incrementally add decorations (milk, sugar, whipped cream) to it, with each new decoration extending the functionality of the previous one.
 */

public class DecoratorPatternExample {
    public static void main(String[] args) {
        // Create a simple coffee
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println(simpleCoffee.getDescription() + " Cost: $" + simpleCoffee.cost());

        // Decorate with milk
        Coffee milkCoffee = new Milk(simpleCoffee);
        System.out.println(milkCoffee.getDescription() + " Cost: $" + milkCoffee.cost());

        // Decorate with milk and sugar
        Coffee milkSugarCoffee = new Sugar(milkCoffee);
        System.out.println(milkSugarCoffee.getDescription() + " Cost: $" + milkSugarCoffee.cost());

        // Decorate with milk, sugar, and whipped cream
        Coffee milkSugarWhippedCreamCoffee = new WhippedCream(milkSugarCoffee);
        System.out.println(milkSugarWhippedCreamCoffee.getDescription() + " Cost: $" + milkSugarWhippedCreamCoffee.cost());
    }
}

