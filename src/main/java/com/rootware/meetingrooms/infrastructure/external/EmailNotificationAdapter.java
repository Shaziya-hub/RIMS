package com.rootware.meetingrooms.infrastructure.external;

import org.springframework.stereotype.Component;

@Component
public class EmailNotificationAdapter {
    public void sendBookingNotification(String to, String subject, String body) {
        // integrate with an email provider
    }
}
