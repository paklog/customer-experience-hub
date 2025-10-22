package com.paklog.customerx.domain.aggregate;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Document(collection = "customer_profiles")
public class CustomerProfile {
    @Id private String customerId;
    private String name;
    private String email;
    private String phone;
    private String companyName;
    @Builder.Default private Map<String, Boolean> notificationPreferences = new HashMap<>();
    @Builder.Default private List<String> orderIds = new ArrayList<>();
    private Instant createdAt;
    private Instant lastActivityAt;
    private double npsScore;
    private int totalOrders;
}
