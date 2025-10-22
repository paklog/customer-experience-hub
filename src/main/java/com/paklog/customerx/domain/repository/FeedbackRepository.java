package com.paklog.customerx.domain.repository;
import com.paklog.customerx.domain.aggregate.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
public interface FeedbackRepository extends MongoRepository<Feedback, String> {
    List<Feedback> findByCustomerId(String customerId);
}
