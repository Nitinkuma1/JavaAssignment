package com.capgemini.springpaymentsystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringPaymentSystemApplication implements CommandLineRunner {

    private final ApplicationContext context;
    private final CreditCardPayment creditCardPayment;

    // Constructor Injection (Best Practice)
    public SpringPaymentSystemApplication(ApplicationContext context,
                            CreditCardPayment creditCardPayment) {
        this.context = context;
        this.creditCardPayment = creditCardPayment;
    }

    public static void main(String[] args) {

        // Correct way to start Spring Boot
        SpringApplication.run(SpringPaymentSystemApplication.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println("----- Getting Default Bean -----");

        creditCardPayment.pay(5000);

        System.out.println("----- Testing Prototype Scope -----");

        UpiPayment upi1 = context.getBean(UpiPayment.class);
        UpiPayment upi2 = context.getBean(UpiPayment.class);

        System.out.println("Are both UPI beans same? " + (upi1 == upi2));
    }
}
