package com.capgemini.springpaymentsystem;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")        // New object every time
public class UpiPayment {

    public UpiPayment() {
        System.out.println("UpiPayment Bean Created");
    }

    public void pay(double amount) {
        System.out.println("UPI payment of Rs. " + amount + " successful");
    }
}
