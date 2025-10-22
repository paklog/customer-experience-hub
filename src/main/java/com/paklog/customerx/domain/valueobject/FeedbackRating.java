package com.paklog.customerx.domain.valueobject;
public enum FeedbackRating { 
    VERY_POOR(1), POOR(2), NEUTRAL(3), GOOD(4), EXCELLENT(5);
    private final int value;
    FeedbackRating(int value) { this.value = value; }
    public int getValue() { return value; }
}
