package com.paklog.customerx.application.command;

import com.paklog.customerx.domain.valueobject.FeedbackRating;

public record SubmitFeedbackCommand(
    String customerId,
    String orderId,
    FeedbackRating rating,
    String category,
    String comments
) {}
