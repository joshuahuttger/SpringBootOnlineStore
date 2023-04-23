package com.huttger.joshua.customerpoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomerPollerScheduledTask {

	private static final Logger log = LoggerFactory.getLogger(CustomerPollerScheduledTask.class);

	@Autowired
	RestTemplate restTemplate;

	@Bean
	@Scheduled(fixedRate = 5000)
	public void logAllCustomers() throws Exception {
			String customersList = restTemplate.getForObject(
					"http://localhost:8080/customer/all", String.class);
			log.info(customersList);
	}
}
