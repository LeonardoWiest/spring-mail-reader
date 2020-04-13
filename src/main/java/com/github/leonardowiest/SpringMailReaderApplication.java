package com.github.leonardowiest;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMailReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMailReaderApplication.class, args);
	}

	@PostConstruct
	public void initialize() {

		System.out.println("Bean SpringMailReaderApplication registrado.");
	}

}
