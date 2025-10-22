package com.paklog.customerx.application.command;
import lombok.*;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CreateTicketCommand {
    private String customerId;
    private String orderId;
    private String subject;
    private String description;
    private String priority;
}
