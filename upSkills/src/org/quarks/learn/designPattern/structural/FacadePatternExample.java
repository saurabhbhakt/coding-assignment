package org.quarks.learn.designPattern.structural;

class OrderService {
    public void takeOrder() {
        System.out.println("Order taken.");
    }
}

class PaymentService {
    public void processPayment() {
        System.out.println("Payment processed.");
    }
}

class KitchenService {
    public void prepareFood() {
        System.out.println("Food is being prepared.");
    }
}

class DeliveryService {
    public void deliverFood() {
        System.out.println("Food is being delivered.");
    }
}

class RestaurantFacade {
    private final OrderService orderService;
    private final PaymentService paymentService;
    private final KitchenService kitchenService;
    private final DeliveryService deliveryService;

    public RestaurantFacade() {
        this.orderService = new OrderService();
        this.paymentService = new PaymentService();
        this.kitchenService = new KitchenService();
        this.deliveryService = new DeliveryService();
    }

    public void placeOrder() {
        orderService.takeOrder();
        paymentService.processPayment();
        kitchenService.prepareFood();
        deliveryService.deliverFood();
    }
}

/**
 * Subsystem classes: OrderService, PaymentService, KitchenService, and DeliveryService are responsible for individual tasks (ordering, payment, food preparation, and delivery).
 * Facade: The RestaurantFacade class provides a simplified interface. The placeOrder() method encapsulates the interaction with all subsystem classes.
 * Client: The client code only interacts with the RestaurantFacade. It calls the placeOrder() method, and the facade takes care of delegating tasks to the subsystem classes.
 */

public class FacadePatternExample {
    public static void main(String[] args) {
        // Client interacts with the Facade to place an order
        RestaurantFacade restaurantFacade = new RestaurantFacade();
        restaurantFacade.placeOrder();
    }
}

