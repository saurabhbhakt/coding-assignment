package com.quarks.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customer")
public class Customer {
    @Id
    private String id;
    @Field("customerName")
    private String customerName;
    @Field("emailAddress")
    private String emailAddress;
    @Field("phoneNumber")
    private String phoneNumber;
}
