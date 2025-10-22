package com.paklog.customerx.domain.aggregate;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Document(collection = "order_tracking")
public class OrderTracking {
    @Id private String trackingId;
    private String orderId;
    private String customerId;
    private String currentStatus;
    private String currentLocation;
    @Builder.Default private List<StatusUpdate> statusHistory = new ArrayList<>();
    private Instant estimatedDelivery;
    private Instant actualDelivery;
    private String carrierInfo;
    private String trackingNumber;

    @Data @NoArgsConstructor @AllArgsConstructor
    public static class StatusUpdate {
        private String status;
        private String location;
        private Instant timestamp;
        private String notes;
    }
}
