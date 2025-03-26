package com.quarks.kafka.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillMessage {
    private String id;
    private Double amount;
    private LocalDate dueDate;
    private CustomerMessage customerMessage;
}
