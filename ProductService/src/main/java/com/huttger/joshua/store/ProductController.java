package com.huttger.joshua.store;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huttger.joshua.store.data.Product;
import com.huttger.joshua.store.data.ProductDataStore;

@RestController
public class ProductController {
	@GetMapping("/product")
	public Product product(@RequestParam(value = "productId", defaultValue="chickenId") String productId) {
		return ProductDataStore.get(productId);
	}
}