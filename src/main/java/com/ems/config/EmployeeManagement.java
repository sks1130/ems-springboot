package com.ems.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = {
        "com.ems.controller",
        "com.ems.dao",
        "com.ems.service" }, basePackageClasses = EmployeeManagement.class)
public class EmployeeManagement {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeManagement.class);

	public static void main(String[] args) throws Exception {
		//instantiating the spring boot application.
		logger.info("instantiating the EMS app");
		SpringApplication.run(EmployeeManagement.class, args);
	}

	//following is the code to instantiate the MongoTemplate Bean
    @SuppressWarnings("deprecation")
	@Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        UserCredentials userCredentials = new UserCredentials("", "");
        return new SimpleMongoDbFactory(mongoClient, "ems", userCredentials);
    }
 
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }
}
  
