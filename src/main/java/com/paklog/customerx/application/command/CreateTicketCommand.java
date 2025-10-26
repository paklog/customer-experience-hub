package com.paklog.customerx.application.command;

public record CreateTicketCommand(
    String customerId,
    String orderId,
    String subject,
    String description,
    String priority
) {}
