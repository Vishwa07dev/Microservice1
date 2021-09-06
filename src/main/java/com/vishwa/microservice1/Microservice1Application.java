package com.vishwa.microservice1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * 1. I want to create a service - Expose REST EndPoints
 *
 *    GET 127.0.0.1:7001/ms1/v1/messages
 *
 * 2. I want to auto registered with Eureka Server
 * a. Add the dependency Eureka client in POM.xml
 * b. Add configurations in the application.properties file
 * c. Add the annotation in the main class
 *
 */


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@RestController
@RequestMapping("/messages")
public class Microservice1Application {

  @Autowired
	private Microservice2Client microservice2Client;

	public static void main(String[] args) {
		SpringApplication.run(Microservice1Application.class, args);
	}

	@GetMapping
	public ResponseEntity helloMessage(){

		return new ResponseEntity("Hello from Microservice1 plus getting the response from other service " + microservice2Client.getMessage(), HttpStatus.OK);
	}




}
