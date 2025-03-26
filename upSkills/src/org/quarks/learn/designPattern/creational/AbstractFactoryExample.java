package org.quarks.learn.designPattern.creational;

/***
 * Button and Checkbox are abstract products that define the operations that the concrete products will implement.
 * WindowsButton and WindowsCheckbox are concrete implementations of the Button and Checkbox for the Windows platform.
 * MacButton and MacCheckbox are concrete implementations of the Button and Checkbox for the Mac platform.
 * UIFactory is the abstract factory interface, which defines methods to create abstract products (Button and Checkbox).
 * WindowsUIFactory and MacUIFactory are concrete factories that implement the UIFactory interface and create platform-specific components.
 */

// Abstract Product for Button
interface Button {
    void render();
}

// Abstract Product for Checkbox
interface Checkbox {
    void render();
}

// Concrete Product for Button (Windows)
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Windows Button.");
    }
}

// Concrete Product for Checkbox (Windows)
class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering Windows Checkbox.");
    }
}

// Concrete Product for Button (Mac)
class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Mac Button.");
    }
}

// Concrete Product for Checkbox (Mac)
class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering Mac Checkbox.");
    }
}

interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factory for Windows UI
class WindowsUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// Concrete Factory for Mac UI
class MacUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

public class AbstractFactoryExample {
    public static void main(String[] args) {
        // Create a Windows UI factory
        UIFactory windowsFactory = new WindowsUIFactory();

        // Create and render a Windows Button and Checkbox
        Button windowsButton = windowsFactory.createButton();
        windowsButton.render();

        Checkbox windowsCheckbox = windowsFactory.createCheckbox();
        windowsCheckbox.render();

        System.out.println();

        // Create a Mac UI factory
        UIFactory macFactory = new MacUIFactory();

        // Create and render a Mac Button and Checkbox
        Button macButton = macFactory.createButton();
        macButton.render();

        Checkbox macCheckbox = macFactory.createCheckbox();
        macCheckbox.render();
    }
}

