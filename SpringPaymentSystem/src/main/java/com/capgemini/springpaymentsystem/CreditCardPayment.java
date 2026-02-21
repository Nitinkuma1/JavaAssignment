package com.capgemini.springpaymentsystem;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component                 // Spring will manage this class
@Scope("singleton")        // Only one object
@Primary                   // Make this default bean
public class CreditCardPayment {

    // Constructor
    public CreditCardPayment() {
        System.out.println("CreditCardPayment Bean Created");
    }

    // Initialization method
    @PostConstruct
    public void init() {
        System.out.println("CreditCardPayment Bean Initialized");
    }

    // Destruction method
    @PreDestroy
    public void destroy() {
        System.out.println("CreditCardPayment Bean Destroyed");
    }

    public void pay(double amount) {
        System.out.println("Credit Card payment of Rs. " + amount + " successful");
    }
}
