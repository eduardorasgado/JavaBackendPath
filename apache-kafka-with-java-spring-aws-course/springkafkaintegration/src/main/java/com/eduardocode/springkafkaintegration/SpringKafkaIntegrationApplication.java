package com.eduardocode.springkafkaintegration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class SpringKafkaIntegrationApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringKafkaIntegrationApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaIntegrationApplication.class, args);
	}

	@KafkaListener(topics = {"integration-topic"}, groupId = "integration-group")
	public void listen(String message) {
		logger.info("Message received: {}", message);
	}
}
