package com.paklog.customerx.domain.aggregate;

import com.paklog.customerx.domain.valueobject.TicketStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
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
    @Builder.Default private List<Comment> comments = new ArrayList<>();
    private Instant createdAt;
    private Instant resolvedAt;
    private Instant slaDeadline;

    @Data @NoArgsConstructor @AllArgsConstructor
    public static class Comment {
        private String commentId;
        private String author;
        private String content;
        private Instant timestamp;
    }
}
