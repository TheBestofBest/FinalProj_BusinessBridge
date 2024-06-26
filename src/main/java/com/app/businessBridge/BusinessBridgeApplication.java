package com.app.businessBridge;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableBatchProcessing
@EnableJpaAuditing
@EnableScheduling
public class BusinessBridgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessBridgeApplication.class, args);
	}

}
