package com.paklog.customer.experience.hub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * Customer Experience Hub
 *
 * Self-service portal and customer preferences management
 *
 * @author Paklog Team
 * @version 1.0.0
 */
@SpringBootApplication
@EnableKafka
@EnableMongoAuditing
public class CustomerExperienceHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerExperienceHubApplication.class, args);
    }
}