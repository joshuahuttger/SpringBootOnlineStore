package com.huttger.joshua.customerpoller;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class CustomerPollerApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(CustomerPollerApplication.class);
		app.setDefaultProperties(Collections
		          .singletonMap("server.port", "8083"));
		app.run(args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	

}
