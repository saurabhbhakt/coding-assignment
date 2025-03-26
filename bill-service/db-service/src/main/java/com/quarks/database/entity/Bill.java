package com.quarks.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bill")
public class Bill {
    @Id
    private String id;
    @Field("customerId")
    private String customerId;
    @Field("amount")
    private Double amount;
    @Field("dueDate")
    private LocalDate dueDate;
    @Field("status")
    private BillStatus status;
}

