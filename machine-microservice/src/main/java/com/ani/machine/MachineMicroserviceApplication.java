package com.ani.machine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MachineMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MachineMicroserviceApplication.class, args);
	}
}
