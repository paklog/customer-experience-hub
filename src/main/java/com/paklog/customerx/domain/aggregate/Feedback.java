package com.paklog.customerx.domain.aggregate;

import com.paklog.customerx.domain.valueobject.FeedbackRating;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
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

 // Getters
 public String getFeedbackId() { return feedbackId; }
 public String getCustomerId() { return customerId; }
 public String getOrderId() { return orderId; }
 public FeedbackRating getRating() { return rating; }
 public String getCategory() { return category; }
 public String getComments() { return comments; }
 public Instant getSubmittedAt() { return submittedAt; }
 public boolean isRespondedTo() { return respondedTo; }

 // Setters
 public void setFeedbackId(String feedbackId) { this.feedbackId = feedbackId; }
 public void setCustomerId(String customerId) { this.customerId = customerId; }
 public void setOrderId(String orderId) { this.orderId = orderId; }
 public void setRating(FeedbackRating rating) { this.rating = rating; }
 public void setCategory(String category) { this.category = category; }
 public void setComments(String comments) { this.comments = comments; }
 public void setSubmittedAt(Instant submittedAt) { this.submittedAt = submittedAt; }
 public void setRespondedTo(boolean respondedTo) { this.respondedTo = respondedTo; }

 // Builder
 public static Builder builder() { return new Builder(); }

 public static class Builder {
  private String feedbackId;
  private String customerId;
  private String orderId;
  private FeedbackRating rating;
  private String category;
  private String comments;
  private Instant submittedAt;
  private boolean respondedTo;

  public Builder feedbackId(String feedbackId) { this.feedbackId = feedbackId; return this; }
  public Builder customerId(String customerId) { this.customerId = customerId; return this; }
  public Builder orderId(String orderId) { this.orderId = orderId; return this; }
  public Builder rating(FeedbackRating rating) { this.rating = rating; return this; }
  public Builder category(String category) { this.category = category; return this; }
  public Builder comments(String comments) { this.comments = comments; return this; }
  public Builder submittedAt(Instant submittedAt) { this.submittedAt = submittedAt; return this; }
  public Builder respondedTo(boolean respondedTo) { this.respondedTo = respondedTo; return this; }

  public Feedback build() {
   Feedback obj = new Feedback();
   obj.feedbackId = this.feedbackId;
   obj.customerId = this.customerId;
   obj.orderId = this.orderId;
   obj.rating = this.rating;
   obj.category = this.category;
   obj.comments = this.comments;
   obj.submittedAt = this.submittedAt;
   obj.respondedTo = this.respondedTo;
   return obj;
  }
 }
}
