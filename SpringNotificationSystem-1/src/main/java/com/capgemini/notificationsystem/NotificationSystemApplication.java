package com.capgemini.notificationsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NotificationSystemApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(NotificationSystemApplication.class, args);

        System.out.println("\n--- Container Started ---");

        System.out.println("\n--- Getting emailBean ---");
        Notification email =
                (Notification) context.getBean("emailBean");
        email.send("Welcome to Spring!");

        System.out.println("\n--- Getting smsBean ---");
        Notification sms =
                (Notification) context.getBean("smsBean");
        sms.send("OTP Sent Successfully!");

        System.out.println("\n--- Closing Container ---");
        context.close();
    }
}