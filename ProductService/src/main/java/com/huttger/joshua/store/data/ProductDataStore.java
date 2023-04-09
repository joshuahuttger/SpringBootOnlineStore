package com.huttger.joshua.store.data;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductDataStore extends MongoRepository<Product, String> {
  public Optional<Product> findById(String productId);
}
