package com.paklog.customerx.domain.aggregate;

import com.paklog.customerx.domain.valueobject.FeedbackRating;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Document(collection = "feedback")
public class Feedback {
    @Id private String feedbackId;
    private String customerId;
    private String orderId;
    private FeedbackRating rating;
    private String category;
    private String comments;
    private Instant submittedAt;
    private boolean respondedTo;
}
