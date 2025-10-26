package com.paklog.customerx.domain.aggregate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.*;
@Document(collection = "customer_profiles")
public class CustomerProfile {
 @Id private String customerId;
 private String name;
 private String email;
 private String phone;
 private String companyName;
 private Map<String, Boolean> notificationPreferences = new HashMap<>();
 private List<String> orderIds = new ArrayList<>();
 private Instant createdAt;
 private Instant lastActivityAt;
 private double npsScore;
 private int totalOrders;

 // Getters
 public String getName() { return name; }
 public String getEmail() { return email; }
 public String getPhone() { return phone; }
 public String getCompanyName() { return companyName; }
 public Instant getCreatedAt() { return createdAt; }
 public Instant getLastActivityAt() { return lastActivityAt; }
 public double getNpsScore() { return npsScore; }
 public int getTotalOrders() { return totalOrders; }

 // Setters
 public void setName(String name) { this.name = name; }
 public void setEmail(String email) { this.email = email; }
 public void setPhone(String phone) { this.phone = phone; }
 public void setCompanyName(String companyName) { this.companyName = companyName; }
 public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
 public void setLastActivityAt(Instant lastActivityAt) { this.lastActivityAt = lastActivityAt; }
 public void setNpsScore(double npsScore) { this.npsScore = npsScore; }
 public void setTotalOrders(int totalOrders) { this.totalOrders = totalOrders; }

 // Builder
 public static Builder builder() { return new Builder(); }

 public static class Builder {
 private String name;
 private String email;
 private String phone;
 private String companyName;
 private Instant lastActivityAt;
 private double npsScore;
 private int totalOrders;

 public Builder name(String name) { this.name = name; return this; }
 public Builder email(String email) { this.email = email; return this; }
 public Builder phone(String phone) { this.phone = phone; return this; }
 public Builder companyName(String companyName) { this.companyName = companyName; return this; }
 public Builder lastActivityAt(Instant lastActivityAt) { this.lastActivityAt = lastActivityAt; return this; }
 public Builder npsScore(double npsScore) { this.npsScore = npsScore; return this; }
 public Builder totalOrders(int totalOrders) { this.totalOrders = totalOrders; return this; }

 public CustomerProfile build() {
 CustomerProfile obj = new CustomerProfile();
 obj.name = this.name;
 obj.email = this.email;
 obj.phone = this.phone;
 obj.companyName = this.companyName;
 obj.lastActivityAt = this.lastActivityAt;
 obj.npsScore = this.npsScore;
 obj.totalOrders = this.totalOrders;
 return obj;
 

}
}
}
