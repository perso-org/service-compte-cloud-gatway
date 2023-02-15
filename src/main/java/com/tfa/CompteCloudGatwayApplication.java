package com.tfa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CompteCloudGatwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompteCloudGatwayApplication.class, args);
	}

}
