package com.paklog.customerx.domain.aggregate;

import com.paklog.customerx.domain.valueobject.TicketStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.*;
@Document(collection = "support_tickets")
public class SupportTicket {
 @Id private String ticketId;
 private String customerId;
 private String orderId;
 private String subject;
 private String description;
 private TicketStatus status;
 private String priority;
 private String assignedTo;
 private List<Comment> comments = new ArrayList<>();
 private Instant createdAt;
 private Instant resolvedAt;
 private Instant slaDeadline;
public static class Comment {
 private String commentId;
 private String author;
 private String content;
 private Instant timestamp;

 public String getCommentId() { return commentId; }
 public String getAuthor() { return author; }
 public String getContent() { return content; }
 public Instant getTimestamp() { return timestamp; }

 public void setCommentId(String commentId) { this.commentId = commentId; }
 public void setAuthor(String author) { this.author = author; }
 public void setContent(String content) { this.content = content; }
 public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }
 }

 // Getters
 public String getTicketId() { return ticketId; }
 public String getCustomerId() { return customerId; }
 public String getOrderId() { return orderId; }
 public String getSubject() { return subject; }
 public String getDescription() { return description; }
 public TicketStatus getStatus() { return status; }
 public String getPriority() { return priority; }
 public String getAssignedTo() { return assignedTo; }
 public List<Comment> getComments() { return comments; }
 public Instant getCreatedAt() { return createdAt; }
 public Instant getResolvedAt() { return resolvedAt; }
 public Instant getSlaDeadline() { return slaDeadline; }

 // Setters
 public void setTicketId(String ticketId) { this.ticketId = ticketId; }
 public void setCustomerId(String customerId) { this.customerId = customerId; }
 public void setOrderId(String orderId) { this.orderId = orderId; }
 public void setSubject(String subject) { this.subject = subject; }
 public void setDescription(String description) { this.description = description; }
 public void setStatus(TicketStatus status) { this.status = status; }
 public void setPriority(String priority) { this.priority = priority; }
 public void setAssignedTo(String assignedTo) { this.assignedTo = assignedTo; }
 public void setComments(List<Comment> comments) { this.comments = comments; }
 public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
 public void setResolvedAt(Instant resolvedAt) { this.resolvedAt = resolvedAt; }
 public void setSlaDeadline(Instant slaDeadline) { this.slaDeadline = slaDeadline; }

 // Builder
 public static Builder builder() { return new Builder(); }

 public static class Builder {
 private String ticketId;
 private String customerId;
 private String orderId;
 private String subject;
 private String description;
 private TicketStatus status;
 private String priority;
 private String assignedTo;
 private List<Comment> comments;
 private Instant createdAt;
 private Instant resolvedAt;
 private Instant slaDeadline;

 public Builder ticketId(String ticketId) { this.ticketId = ticketId; return this; }
 public Builder customerId(String customerId) { this.customerId = customerId; return this; }
 public Builder orderId(String orderId) { this.orderId = orderId; return this; }
 public Builder subject(String subject) { this.subject = subject; return this; }
 public Builder description(String description) { this.description = description; return this; }
 public Builder status(TicketStatus status) { this.status = status; return this; }
 public Builder priority(String priority) { this.priority = priority; return this; }
 public Builder assignedTo(String assignedTo) { this.assignedTo = assignedTo; return this; }
 public Builder comments(List<Comment> comments) { this.comments = comments; return this; }
 public Builder createdAt(Instant createdAt) { this.createdAt = createdAt; return this; }
 public Builder resolvedAt(Instant resolvedAt) { this.resolvedAt = resolvedAt; return this; }
 public Builder slaDeadline(Instant slaDeadline) { this.slaDeadline = slaDeadline; return this; }

 public SupportTicket build() {
 SupportTicket obj = new SupportTicket();
 obj.ticketId = this.ticketId;
 obj.customerId = this.customerId;
 obj.orderId = this.orderId;
 obj.subject = this.subject;
 obj.description = this.description;
 obj.status = this.status;
 obj.priority = this.priority;
 obj.assignedTo = this.assignedTo;
 if (this.comments != null) obj.comments = this.comments;
 obj.createdAt = this.createdAt;
 obj.resolvedAt = this.resolvedAt;
 obj.slaDeadline = this.slaDeadline;
 return obj;
 

}
}
}
