package com.bjttsf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class CompanyRoleApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CompanyRoleApplication.class, args);
	}
}