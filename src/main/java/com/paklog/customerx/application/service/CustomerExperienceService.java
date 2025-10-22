package com.paklog.customerx.application.service;

import com.paklog.customerx.application.command.*;
import com.paklog.customerx.domain.aggregate.*;
import com.paklog.customerx.domain.repository.*;
import com.paklog.customerx.domain.service.*;
import com.paklog.customerx.domain.valueobject.TicketStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.Instant;
import java.util.*;

@Service @RequiredArgsConstructor @Slf4j
public class CustomerExperienceService {
    private final CustomerProfileRepository customerRepository;
    private final SupportTicketRepository ticketRepository;
    private final FeedbackRepository feedbackRepository;
    private final OrderTrackingRepository trackingRepository;
    private final FeedbackAnalysisService analysisService;

    @Transactional
    public SupportTicket createTicket(CreateTicketCommand command) {
        SupportTicket ticket = SupportTicket.builder()
                .ticketId(UUID.randomUUID().toString())
                .customerId(command.getCustomerId())
                .orderId(command.getOrderId())
                .subject(command.getSubject())
                .description(command.getDescription())
                .status(TicketStatus.OPEN)
                .priority(command.getPriority())
                .createdAt(Instant.now())
                .slaDeadline(Instant.now().plusSeconds(86400))
                .build();
        return ticketRepository.save(ticket);
    }

    @Transactional
    public Feedback submitFeedback(SubmitFeedbackCommand command) {
        Feedback feedback = Feedback.builder()
                .feedbackId(UUID.randomUUID().toString())
                .customerId(command.getCustomerId())
                .orderId(command.getOrderId())
                .rating(command.getRating())
                .category(command.getCategory())
                .comments(command.getComments())
                .submittedAt(Instant.now())
                .respondedTo(false)
                .build();
        return feedbackRepository.save(feedback);
    }

    @Transactional(readOnly = true)
    public OrderTracking trackOrder(String orderId) {
        return trackingRepository.findByOrderId(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }

    @Transactional(readOnly = true)
    public List<SupportTicket> getCustomerTickets(String customerId) {
        return ticketRepository.findByCustomerId(customerId);
    }

    @Transactional(readOnly = true)
    public double calculateCustomerNPS(String customerId) {
        List<Feedback> feedbacks = feedbackRepository.findByCustomerId(customerId);
        return analysisService.calculateNPS(feedbacks);
    }
}
