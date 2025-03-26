package org.quarks.learn.designPattern.behavioral;

// State interface
interface TCPState {
    void open(TCPConnection connection);
    void close(TCPConnection connection);
    void acknowledge(TCPConnection connection);
}

// Concrete state: Listening
class ListeningState implements TCPState {

    @Override
    public void open(TCPConnection connection) {
        System.out.println("Connection established. Transitioning to ESTABLISHED state.");
        connection.setState(new EstablishedState());
    }

    @Override
    public void close(TCPConnection connection) {
        System.out.println("Connection is closing from LISTENING state.");
        connection.setState(new ClosedState());
    }

    @Override
    public void acknowledge(TCPConnection connection) {
        System.out.println("Cannot acknowledge from LISTENING state.");
    }
}

// Concrete state: Established
class EstablishedState implements TCPState {

    @Override
    public void open(TCPConnection connection) {
        System.out.println("Connection already established. No action needed.");
    }

    @Override
    public void close(TCPConnection connection) {
        System.out.println("Closing connection from ESTABLISHED state.");
        connection.setState(new ClosedState());
    }

    @Override
    public void acknowledge(TCPConnection connection) {
        System.out.println("Acknowledgement received in ESTABLISHED state.");
        connection.setState(new ClosedWaitState());
    }
}

// Concrete state: Closed
class ClosedState implements TCPState {

    @Override
    public void open(TCPConnection connection) {
        System.out.println("Re-opening connection. Transitioning to LISTENING state.");
        connection.setState(new ListeningState());
    }

    @Override
    public void close(TCPConnection connection) {
        System.out.println("Connection is already closed.");
    }

    @Override
    public void acknowledge(TCPConnection connection) {
        System.out.println("Cannot acknowledge in CLOSED state.");
    }
}

// Concrete state: ClosedWait
class ClosedWaitState implements TCPState {

    @Override
    public void open(TCPConnection connection) {
        System.out.println("Re-opening connection. Transitioning to LISTENING state.");
        connection.setState(new ListeningState());
    }

    @Override
    public void close(TCPConnection connection) {
        System.out.println("Closing connection from CLOSED-WAIT state.");
        connection.setState(new ClosedState());
    }

    @Override
    public void acknowledge(TCPConnection connection) {
        System.out.println("Acknowledgement received in CLOSED-WAIT state.");
        connection.setState(new ClosedState());
    }
}



// Context: TCP Connection
class TCPConnection {
    private TCPState state;

    public TCPConnection() {
        this.state = new ClosedState();  // Initial state is Closed
    }

    public void setState(TCPState state) {
        this.state = state;
    }

    public void open() {
        state.open(this);
    }

    public void close() {
        state.close(this);
    }

    public void acknowledge() {
        state.acknowledge(this);
    }
}


public class StatePatternDemo {
    public static void main(String[] args) {
        // Create a TCPConnection
        TCPConnection connection = new TCPConnection();

        // Simulate various operations based on state
        connection.open();  // Transition to LISTENING
        connection.acknowledge();  // Transition to ESTABLISHED
        connection.close();  // Transition to CLOSED-WAIT
        connection.close();  // Transition to CLOSED
        connection.open();  // Transition back to LISTENING
    }
}
