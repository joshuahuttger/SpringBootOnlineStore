package com.huttger.joshua.store.data;

public class Product {

	private String productId;
	private String desc;

	public Product(String productId) {
		this.productId = productId;
		this.desc = "This is a product desc "+productId;
	}

	public String getProductId() {
		return productId;
	}

	public String getDesc() {
		return desc;
	}

}
