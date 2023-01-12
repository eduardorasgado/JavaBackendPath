package com.eduardocode.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.eduardocode.app.producers",
		"com.eduardocode.app.configs"
})
public class ScheduledSpringKafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduledSpringKafkaProducerApplication.class, args);
	}
}
