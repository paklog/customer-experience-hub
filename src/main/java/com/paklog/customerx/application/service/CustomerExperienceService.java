package com.paklog.customerx.application.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.paklog.customerx.application.command.*;
import com.paklog.customerx.domain.aggregate.*;
import com.paklog.customerx.domain.repository.*;
import com.paklog.customerx.domain.service.*;
import com.paklog.customerx.domain.valueobject.TicketStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.Instant;
import java.util.*;

@Service public class CustomerExperienceService {
 private static final Logger log = LoggerFactory.getLogger(CustomerExperienceService.class);

 private final CustomerProfileRepository customerRepository;
 private final SupportTicketRepository ticketRepository;
 private final FeedbackRepository feedbackRepository;
 private final OrderTrackingRepository trackingRepository;
 private final FeedbackAnalysisService analysisService;
 public CustomerExperienceService(CustomerProfileRepository customerRepository, SupportTicketRepository ticketRepository, FeedbackRepository feedbackRepository, OrderTrackingRepository trackingRepository, FeedbackAnalysisService analysisService) {
 this.customerRepository = customerRepository;
 this.ticketRepository = ticketRepository;
 this.feedbackRepository = feedbackRepository;
 this.trackingRepository = trackingRepository;
 this.analysisService = analysisService;
 }

 @Transactional
 public SupportTicket createTicket(CreateTicketCommand command) {
 SupportTicket ticket = SupportTicket.builder()
 .ticketId(UUID.randomUUID().toString())
 .customerId(command.customerId())
 .orderId(command.orderId())
 .subject(command.subject())
 .description(command.description())
 .status(TicketStatus.OPEN)
 .priority(command.priority())
 .createdAt(Instant.now())
 .slaDeadline(Instant.now().plusSeconds(86400))
 .build();
 return ticketRepository.save(ticket);
 }

 @Transactional
 public Feedback submitFeedback(SubmitFeedbackCommand command) {
 Feedback feedback = Feedback.builder()
 .feedbackId(UUID.randomUUID().toString())
 .customerId(command.customerId())
 .orderId(command.orderId())
 .rating(command.rating())
 .category(command.category())
 .comments(command.comments())
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
