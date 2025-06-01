package com.sai.kafka.producer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

	private String transactionId;
	private String sourceAcc;
	private String destAcc;
	private double amount;
	private LocalDate txDate;

}
