package com.huttger.joshua.store.customer.scheduledtasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.huttger.joshua.store.customer.data.CustomerDataStore;

@Component
public class CustomerScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(CustomerScheduledTasks.class);
	
	@Autowired
	private CustomerDataStore customerRepository;

	@Scheduled(fixedRate = 5000)
	public void logCustomerCount() {
		log.info("There are currently {} customers.", customerRepository.count());
	}
}
