package com.quarks.kafka.dto;


import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerMessage {
    private String id;
    private String customerName;
    private String emailAddress;
    private String phoneNumber;
}
