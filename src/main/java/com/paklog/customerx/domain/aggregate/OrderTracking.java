package com.paklog.customerx.domain.aggregate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.*;
@Document(collection = "order_tracking")
public class OrderTracking {
 @Id private String trackingId;
 private String orderId;
 private String customerId;
 private String currentStatus;
 private String currentLocation;
 private List<StatusUpdate> statusHistory = new ArrayList<>();
 private Instant estimatedDelivery;
 private Instant actualDelivery;
 private String carrierInfo;
 private String trackingNumber;
public static class StatusUpdate {
 private String status;
 private String location;
 private Instant timestamp;
 private String notes;

 public String getStatus() { return status; }
 public String getLocation() { return location; }
 public Instant getTimestamp() { return timestamp; }
 public String getNotes() { return notes; }

 public void setStatus(String status) { this.status = status; }
 public void setLocation(String location) { this.location = location; }
 public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }
 public void setNotes(String notes) { this.notes = notes; }
 }

 // Getters
 public String getTrackingId() { return trackingId; }
 public String getOrderId() { return orderId; }
 public String getCustomerId() { return customerId; }
 public String getCurrentStatus() { return currentStatus; }
 public String getCurrentLocation() { return currentLocation; }
 public List<StatusUpdate> getStatusHistory() { return statusHistory; }
 public Instant getEstimatedDelivery() { return estimatedDelivery; }
 public Instant getActualDelivery() { return actualDelivery; }
 public String getCarrierInfo() { return carrierInfo; }
 public String getTrackingNumber() { return trackingNumber; }

 // Setters
 public void setTrackingId(String trackingId) { this.trackingId = trackingId; }
 public void setOrderId(String orderId) { this.orderId = orderId; }
 public void setCustomerId(String customerId) { this.customerId = customerId; }
 public void setCurrentStatus(String currentStatus) { this.currentStatus = currentStatus; }
 public void setCurrentLocation(String currentLocation) { this.currentLocation = currentLocation; }
 public void setStatusHistory(List<StatusUpdate> statusHistory) { this.statusHistory = statusHistory; }
 public void setEstimatedDelivery(Instant estimatedDelivery) { this.estimatedDelivery = estimatedDelivery; }
 public void setActualDelivery(Instant actualDelivery) { this.actualDelivery = actualDelivery; }
 public void setCarrierInfo(String carrierInfo) { this.carrierInfo = carrierInfo; }
 public void setTrackingNumber(String trackingNumber) { this.trackingNumber = trackingNumber; }

 // Builder
 public static Builder builder() { return new Builder(); }

 public static class Builder {
 private String trackingId;
 private String orderId;
 private String customerId;
 private String currentStatus;
 private String currentLocation;
 private List<StatusUpdate> statusHistory;
 private Instant estimatedDelivery;
 private Instant actualDelivery;
 private String carrierInfo;
 private String trackingNumber;

 public Builder trackingId(String trackingId) { this.trackingId = trackingId; return this; }
 public Builder orderId(String orderId) { this.orderId = orderId; return this; }
 public Builder customerId(String customerId) { this.customerId = customerId; return this; }
 public Builder currentStatus(String currentStatus) { this.currentStatus = currentStatus; return this; }
 public Builder currentLocation(String currentLocation) { this.currentLocation = currentLocation; return this; }
 public Builder statusHistory(List<StatusUpdate> statusHistory) { this.statusHistory = statusHistory; return this; }
 public Builder estimatedDelivery(Instant estimatedDelivery) { this.estimatedDelivery = estimatedDelivery; return this; }
 public Builder actualDelivery(Instant actualDelivery) { this.actualDelivery = actualDelivery; return this; }
 public Builder carrierInfo(String carrierInfo) { this.carrierInfo = carrierInfo; return this; }
 public Builder trackingNumber(String trackingNumber) { this.trackingNumber = trackingNumber; return this; }

 public OrderTracking build() {
 OrderTracking obj = new OrderTracking();
 obj.trackingId = this.trackingId;
 obj.orderId = this.orderId;
 obj.customerId = this.customerId;
 obj.currentStatus = this.currentStatus;
 obj.currentLocation = this.currentLocation;
 if (this.statusHistory != null) obj.statusHistory = this.statusHistory;
 obj.estimatedDelivery = this.estimatedDelivery;
 obj.actualDelivery = this.actualDelivery;
 obj.carrierInfo = this.carrierInfo;
 obj.trackingNumber = this.trackingNumber;
 return obj;
 

}
}
}
