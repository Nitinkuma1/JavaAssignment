package com.capgemini.notificationsystem;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("smsBean")  // ✅ Custom Bean Name
@Lazy                  // ✅ Lazy Initialization
public class SmsNotification implements Notification {

    public SmsNotification() {
        System.out.println("SmsNotification Bean Created");
    }

    @Override
    public void send(String message) {
        System.out.println("SMS Notification sent: " + message);
    }
}
