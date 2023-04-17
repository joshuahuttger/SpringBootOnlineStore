package com.huttger.joshua.store.customer.data;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerDataStore extends MongoRepository<Customer, String> {
	  public Optional<Customer> findById(int id);
}
