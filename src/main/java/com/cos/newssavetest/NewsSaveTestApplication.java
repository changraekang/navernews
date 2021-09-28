package com.cos.newssavetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class NewsSaveTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsSaveTestApplication.class, args);
	}

}
