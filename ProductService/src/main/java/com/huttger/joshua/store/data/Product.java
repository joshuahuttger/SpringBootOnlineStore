package com.huttger.joshua.store.data;

import org.springframework.data.annotation.Id;

public class Product {

	@Id
	private String id;
	private String desc;

	public Product(String productId, String desc) {
		this.id = productId;
		this.desc = desc;
	}

	public String getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", desc=" + desc + "]";
	}
	
}
