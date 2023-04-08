package com.huttger.joshua.store.data;

public class ProductDataStore {
	private ProductDataStore() {
		
	}
	
	public static Product get(String productId) {
		return new Product(productId);
	}
}
