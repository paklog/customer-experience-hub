package com.paklog.customerx.domain.repository;
import com.paklog.customerx.domain.aggregate.SupportTicket;
import com.paklog.customerx.domain.valueobject.TicketStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
public interface SupportTicketRepository extends MongoRepository<SupportTicket, String> {
    List<SupportTicket> findByCustomerId(String customerId);
    List<SupportTicket> findByStatus(TicketStatus status);
}
