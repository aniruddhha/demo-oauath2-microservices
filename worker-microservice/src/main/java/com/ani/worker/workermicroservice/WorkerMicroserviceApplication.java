package com.ani.worker.workermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class WorkerMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(WorkerMicroserviceApplication.class, args);
	}
}
