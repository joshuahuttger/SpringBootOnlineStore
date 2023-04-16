package com.huttger.joshua.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huttger.joshua.store.data.Product;
import com.huttger.joshua.store.data.ProductDataStore;

@RestController
public class ProductController {
	@Autowired
	private ProductDataStore productRepository;

	@GetMapping("/product")
	public Product getProduct(@RequestParam(value = "id") String id) {
		return productRepository.findById(id).orElseThrow();
	}

	@PostMapping("/product")
	public Product postProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
}