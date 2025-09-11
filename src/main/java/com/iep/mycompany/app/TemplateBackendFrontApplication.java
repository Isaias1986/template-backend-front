package com.iep.mycompany.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TemplateBackendFrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplateBackendFrontApplication.class, args);
	}

}
