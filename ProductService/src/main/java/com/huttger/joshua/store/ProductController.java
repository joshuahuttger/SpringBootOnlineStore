package com.huttger.joshua.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping/*postMapping*/("/addProduct")
	public Product postProduct(@RequestParam(value = "id") String id, @RequestParam(value = "desc") String desc) {
		return productRepository.save(new Product(id, desc));
	}
}