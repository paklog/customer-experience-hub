package com.paklog.customerx.domain.aggregate;

import com.paklog.customerx.domain.valueobject.NotificationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Document(collection = "notifications")
public class Notification {
    @Id private String notificationId;
    private String customerId;
    private NotificationType type;
    private String subject;
    private String content;
    private String recipient;
    private boolean sent;
    private Instant sentAt;
    private Instant createdAt;
    private String errorMessage;
}
