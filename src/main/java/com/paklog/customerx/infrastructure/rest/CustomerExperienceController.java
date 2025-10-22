package com.paklog.customerx.infrastructure.rest;

import com.paklog.customerx.application.command.*;
import com.paklog.customerx.application.service.CustomerExperienceService;
import com.paklog.customerx.domain.aggregate.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer-experience")
@RequiredArgsConstructor
@Tag(name = "Customer Experience", description = "Customer engagement APIs")
public class CustomerExperienceController {
    private final CustomerExperienceService service;

    @PostMapping("/tickets")
    @Operation(summary = "Create support ticket")
    public ResponseEntity<SupportTicket> createTicket(@RequestBody CreateTicketCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createTicket(command));
    }

    @PostMapping("/feedback")
    @Operation(summary = "Submit feedback")
    public ResponseEntity<Feedback> submitFeedback(@RequestBody SubmitFeedbackCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.submitFeedback(command));
    }

    @GetMapping("/orders/{orderId}/tracking")
    @Operation(summary = "Track order")
    public ResponseEntity<OrderTracking> trackOrder(@PathVariable String orderId) {
        return ResponseEntity.ok(service.trackOrder(orderId));
    }

    @GetMapping("/customers/{customerId}/tickets")
    @Operation(summary = "Get customer tickets")
    public ResponseEntity<List<SupportTicket>> getTickets(@PathVariable String customerId) {
        return ResponseEntity.ok(service.getCustomerTickets(customerId));
    }

    @GetMapping("/customers/{customerId}/nps")
    @Operation(summary = "Get customer NPS")
    public ResponseEntity<Double> getNPS(@PathVariable String customerId) {
        return ResponseEntity.ok(service.calculateCustomerNPS(customerId));
    }
}
