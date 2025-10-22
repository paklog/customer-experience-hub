package com.paklog.customerx.domain.service;

import com.paklog.customerx.domain.aggregate.Notification;
import com.paklog.customerx.domain.valueobject.NotificationType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.Instant;

@Service @Slf4j
public class NotificationService {
    public void sendNotification(Notification notification) {
        log.info("Sending {} notification to {}", notification.getType(), notification.getRecipient());
        notification.setSent(true);
        notification.setSentAt(Instant.now());
    }
}
