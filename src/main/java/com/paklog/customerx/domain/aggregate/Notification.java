package com.paklog.customerx.domain.aggregate;

import com.paklog.customerx.domain.valueobject.NotificationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
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

 // Getters
 public String getCustomerId() { return customerId; }
 public NotificationType getType() { return type; }
 public String getSubject() { return subject; }
 public String getContent() { return content; }
 public String getRecipient() { return recipient; }
 public boolean isSent() { return sent; }
 public Instant getSentAt() { return sentAt; }
 public Instant getCreatedAt() { return createdAt; }
 public String getErrorMessage() { return errorMessage; }

 // Setters
 public void setCustomerId(String customerId) { this.customerId = customerId; }
 public void setType(NotificationType type) { this.type = type; }
 public void setSubject(String subject) { this.subject = subject; }
 public void setContent(String content) { this.content = content; }
 public void setRecipient(String recipient) { this.recipient = recipient; }
 public void setSent(boolean sent) { this.sent = sent; }
 public void setSentAt(Instant sentAt) { this.sentAt = sentAt; }
 public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
 public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }
}
