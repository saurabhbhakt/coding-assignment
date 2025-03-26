package org.quarks.learn.designPattern.behavioral;

// Abstract Handler
abstract class Logger {
    protected int level;
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    protected abstract void write(String message);
}

// Concrete Handlers
class InfoLogger extends Logger {
    public InfoLogger() {
        this.level = 1;
    }

    @Override
    protected void write(String message) {
        System.out.println("INFO Logger: " + message);
    }
}

class DebugLogger extends Logger {
    public DebugLogger() {
        this.level = 2;
    }

    @Override
    protected void write(String message) {
        System.out.println("DEBUG Logger: " + message);
    }
}

class ErrorLogger extends Logger {
    public ErrorLogger() {
        this.level = 3;
    }

    @Override
    protected void write(String message) {
        System.out.println("ERROR Logger: " + message);
    }
}

// Client code
public class ChainOfResponsibilityPatternExample {
    public static void main(String[] args) {
        // Creating the handlers
        Logger infoLogger = new InfoLogger();
        Logger debugLogger = new DebugLogger();
        Logger errorLogger = new ErrorLogger();

        // Setting up the chain of responsibility
        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(errorLogger);

        // Passing messages through the chain
        infoLogger.logMessage(1, "This is an info message.");
        System.out.println();
        infoLogger.logMessage(2, "This is a debug message.");
        System.out.println();
        infoLogger.logMessage(3, "This is an error message.");
    }
}
