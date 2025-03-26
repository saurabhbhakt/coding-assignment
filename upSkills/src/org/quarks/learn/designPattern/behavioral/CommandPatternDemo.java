package org.quarks.learn.designPattern.behavioral;

// Command interface
interface Command {
    void execute();
}


// Concrete command to turn on the light
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Concrete command to turn off the light
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}


// Receiver class, which knows how to perform the operation
class Light {
    public void turnOn() {
        System.out.println("The light is ON");
    }

    public void turnOff() {
        System.out.println("The light is OFF");
    }
}

// Invoker class that triggers commands
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}


public class CommandPatternDemo {
    public static void main(String[] args) {
        // Create a receiver (light)
        Light light = new Light();

        // Create concrete command objects and associate with the light (receiver)
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        // Create invoker (remote control)
        RemoteControl remote = new RemoteControl();

        // Turn on the light using the remote control
        remote.setCommand(lightOn);
        remote.pressButton();

        // Turn off the light using the remote control
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}

