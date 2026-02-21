package com.capgemini.notificationsystem;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("emailBean")   // ✅ Custom Bean Name
public class EmailNotification implements Notification {

    public EmailNotification() {
        System.out.println("EmailNotification Bean Created");
    }

    @PostConstruct
    public void init() {
        System.out.println("EmailNotification Bean Initialized");
    }

    @Override
    public void send(String message) {
        System.out.println("Email Notification sent: " + message);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("EmailNotification Bean Destroyed");
    }
}
