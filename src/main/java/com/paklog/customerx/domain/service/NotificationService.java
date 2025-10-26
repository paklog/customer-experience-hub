package com.paklog.customerx.domain.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.paklog.customerx.domain.aggregate.Notification;
import com.paklog.customerx.domain.valueobject.NotificationType;
import org.springframework.stereotype.Service;
import java.time.Instant;

@Service public class NotificationService {
    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);

    public void sendNotification(Notification notification) {
        log.info("Sending {} notification to {}", notification.getType(), notification.getRecipient());
        notification.setSent(true);
        notification.setSentAt(Instant.now());
    }
}
