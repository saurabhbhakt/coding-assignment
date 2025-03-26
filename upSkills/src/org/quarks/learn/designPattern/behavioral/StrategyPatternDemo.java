package org.quarks.learn.designPattern.behavioral;

// Strategy interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete strategy for Credit Card payment
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card. Card Number: " + cardNumber);
    }
}

// Concrete strategy for PayPal payment
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal. Email: " + email);
    }
}

// Concrete strategy for Bitcoin payment
class BitcoinPayment implements PaymentStrategy {
    private String walletAddress;

    public BitcoinPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Bitcoin. Wallet Address: " + walletAddress);
    }
}

// Context class that uses a strategy
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    // Set the payment strategy dynamically at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Execute the payment using the current strategy
    public void executePayment(int amount) {
        paymentStrategy.pay(amount);
    }
}



public class StrategyPatternDemo {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        // Choose Credit Card payment
        paymentContext.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        paymentContext.executePayment(100);

        // Switch to PayPal payment
        paymentContext.setPaymentStrategy(new PayPalPayment("user@example.com"));
        paymentContext.executePayment(200);

        // Switch to Bitcoin payment
        paymentContext.setPaymentStrategy(new BitcoinPayment("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa"));
        paymentContext.executePayment(300);
    }
}

