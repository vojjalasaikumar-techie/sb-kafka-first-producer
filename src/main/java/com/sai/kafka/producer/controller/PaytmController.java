package com.sai.kafka.producer.controller;

import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sai.kafka.producer.dto.PaymentRequest;
import com.sai.kafka.producer.dto.PaytmRequest;

@RestController
public class PaytmController {

	@Autowired
	private KafkaTemplate<String, PaymentRequest> kafkaTemplate;

	//private KafkaTemplate<String, String> kafkaTemplate;
	@Value("${paytm.producer.topic.name}")
	private String topicName;
	
	@PostMapping ("/paytm/payment")
	private String doPayment(@RequestBody PaytmRequest<PaymentRequest> paytmRequest) {
		PaymentRequest paymentRequest = paytmRequest.getPayload();
		paymentRequest.setTransactionId(Uuid.randomUuid().toString());
		paymentRequest.setTxDate(LocalDate.now());

		kafkaTemplate.send(topicName, paymentRequest);
		
		return "payment transaction intiated successfully....";
	}

	//Send message to the Kafka as a Json String - It is a recommended way

	/*
	@PostMapping ("/paytm/payment")
	private String doPayment(@RequestBody PaytmRequest<PaymentRequest> paytmRequest) throws JsonProcessingException {
		PaymentRequest paymentRequest = paytmRequest.getPayload();
		paymentRequest.setTransactionId(Uuid.randomUuid().toString());
		paymentRequest.setTxDate(LocalDate.now());

		kafkaTemplate.send(topicName, new ObjectMapper().writeValueAsString(paymentRequest));

		return "payment transaction intiated successfully....";
	}*/

}
