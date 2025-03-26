package org.quarks.learn.designPattern.behavioral;

import java.util.ArrayList;
import java.util.List;

// Subject
class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public int getState() {
        return state;
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

// Observer
abstract class Observer {
    protected Subject subject;
    public abstract void update();
}

// Concrete Observer
class ConcreteObserver extends Observer {
    public ConcreteObserver(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("State updated to: " + subject.getState());
    }
}

// Client code
public class ObserverPatternExample {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new ConcreteObserver(subject);

        subject.setState(10);  // All observers will be notified of the state change
    }
}
