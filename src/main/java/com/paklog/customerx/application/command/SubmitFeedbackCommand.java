package com.paklog.customerx.application.command;
import com.paklog.customerx.domain.valueobject.FeedbackRating;
import lombok.*;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class SubmitFeedbackCommand {
    private String customerId;
    private String orderId;
    private FeedbackRating rating;
    private String category;
    private String comments;
}
