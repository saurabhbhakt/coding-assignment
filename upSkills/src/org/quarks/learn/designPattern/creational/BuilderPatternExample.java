package org.quarks.learn.designPattern.creational;

/**
 * Computer is the product class. It represents the complex object we want to create.
 * ComputerBuilder is the builder class, which provides methods to set the various attributes of the Computer. The build() method is used to construct the final Computer object.
 * The client code uses the ComputerBuilder to construct a Computer object step by step. Each method returns the builder itself (using method chaining), and the final build() method returns the constructed object.
 * The Computer class has a private constructor that ensures objects can only be created through the builder.
 */
class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private String GPU;

    // Constructor is private to ensure the object can only be created via the builder
    private Computer(ComputerBuilder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
    }

    // Getters for the fields
    public String getCPU() {
        return CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public String getStorage() {
        return storage;
    }

    public String getGPU() {
        return GPU;
    }

    // Static inner Builder class
    public static class ComputerBuilder {
        private String CPU;
        private String RAM;
        private String storage;
        private String GPU;

        // Method to set CPU
        public ComputerBuilder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        // Method to set RAM
        public ComputerBuilder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        // Method to set storage
        public ComputerBuilder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        // Method to set GPU
        public ComputerBuilder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        // The build method constructs the Computer object
        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage + ", GPU=" + GPU + "]";
    }
}

public class BuilderPatternExample {
    public static void main(String[] args) {
        // Using the Builder pattern to create a Computer object
        Computer computer = new Computer.ComputerBuilder()
                .setCPU("Intel Core i7")
                .setRAM("16GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA GTX 3080")
                .build();

        System.out.println(computer);  // Output the built computer
    }
}

