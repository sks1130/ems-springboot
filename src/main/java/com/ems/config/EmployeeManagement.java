package com.ems.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagement {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeManagement.class);
	public static void main(String[] args) throws Exception {
		logger.info("instantiating the EMS app");
		SpringApplication.run(EmployeeManagement.class, args);
	}
}

