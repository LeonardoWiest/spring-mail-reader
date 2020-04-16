package com.github.leonardowiest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;

/**
 * 
 * @author Leonardo Wiest
 *
 */
@SpringBootApplication
public class SpringMailReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMailReaderApplication.class, args);
	}

	@Bean
	IntegrationFlow pollingFlow() {

	}

}
