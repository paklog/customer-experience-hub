package com.paklog.customerx.domain.repository;
import com.paklog.customerx.domain.aggregate.CustomerProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
public interface CustomerProfileRepository extends MongoRepository<CustomerProfile, String> {
    Optional<CustomerProfile> findByEmail(String email);
}
