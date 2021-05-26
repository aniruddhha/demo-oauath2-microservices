package com.ani.worker.workermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// docker run -d -p 8787:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin quay.io/keycloak/keycloak:13.0.0

@EnableEurekaClient
@SpringBootApplication
public class WorkerMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(WorkerMicroserviceApplication.class, args);
	}
}
