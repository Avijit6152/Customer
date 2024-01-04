package com.crm;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication

public class CrmApplication {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		SpringApplication.run(CrmApplication.class, args);
		long endTime = System.currentTimeMillis();
		
		long executionTime = endTime - startTime;
		System.out.println("Execution time: " + executionTime + " milliseconds");
	}

}




