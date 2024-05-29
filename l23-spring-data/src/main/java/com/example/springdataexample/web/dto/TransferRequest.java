package com.example.springdataexample.web.dto;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class TransferRequest {
    private int senderId;
    private int receiverId;
    private BigDecimal amount;
}
