package com.huttger.joshua.store.data;

import java.util.Objects;

import org.springframework.data.annotation.Id;

public class Product {

	@Id
	private String id;
	private String desc;

	public Product() {
	}

	public Product(String id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public String getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(desc, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(desc, other.desc) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", desc=" + desc + "]";
	}

}
