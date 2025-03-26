package org.quarks.learn.designPattern.behavioral;

// Abstract Class (Template)
abstract class CaffeineBeverage {
    // Template method, defines the sequence of steps
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // Concrete method (common to all beverages)
    private void boilWater() {
        System.out.println("Boiling water");
    }

    // Abstract method (to be implemented by subclasses)
    protected abstract void brew();

    // Concrete method (common to all beverages)
    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // Abstract method (to be implemented by subclasses)
    protected abstract void addCondiments();
}

// Concrete Class (Tea)
class Tea extends CaffeineBeverage {
    @Override
    protected void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
}

// Concrete Class (Coffee)
class Coffee extends CaffeineBeverage {
    @Override
    protected void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

// Client code
public class TemplateMethodExample {
    public static void main(String[] args) {
        CaffeineBeverage tea = new Tea();
        System.out.println("Preparing Tea:");
        tea.prepareRecipe();
        System.out.println();

        CaffeineBeverage coffee = new Coffee();
        System.out.println("Preparing Coffee:");
        coffee.prepareRecipe();
    }
}

