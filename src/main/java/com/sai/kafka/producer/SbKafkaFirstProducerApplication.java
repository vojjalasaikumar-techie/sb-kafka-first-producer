package com.sai.kafka.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

@SpringBootApplication
public class SbKafkaFirstProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbKafkaFirstProducerApplication.class, args);
	}

}
