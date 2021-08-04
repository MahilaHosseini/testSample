package com.example.testSample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

//@EntityScan(basePackages = {"com.example.testSample.model"})
public class TestSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSampleApplication.class, args);
	}

}
