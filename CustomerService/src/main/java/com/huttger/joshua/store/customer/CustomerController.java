package com.huttger.joshua.store.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huttger.joshua.store.customer.data.Customer;
import com.huttger.joshua.store.customer.data.CustomerDataStore;

@RestController
public class CustomerController {
	@Autowired
	private CustomerDataStore customerRepository;

	@GetMapping("/customer")
	public Customer getCustomer(@RequestParam(value = "id") int id) {
		return customerRepository.findById(id).orElseThrow();
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/customer")
	public Customer postCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
}
