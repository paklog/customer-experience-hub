package com.paklog.customerx.domain.repository;
import com.paklog.customerx.domain.aggregate.OrderTracking;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
public interface OrderTrackingRepository extends MongoRepository<OrderTracking, String> {
    Optional<OrderTracking> findByOrderId(String orderId);
}
