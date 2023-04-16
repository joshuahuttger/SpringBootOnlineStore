package com.huttger.joshua.store;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.huttger.joshua.store.data.Product;


@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class ProductControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Value(value="${local.server.port}")
	private int port;

	@Test
	void testPostAndGet() {
		Product testProduct = new Product("12344", "myDesc");
		assertThat(postProduct(testProduct)).isEqualTo(testProduct);
		assertThat(getProduct(testProduct.getId())).isEqualTo(testProduct);
	}
	
	private Product postProduct(Product product) {
		String url = StoreConfig.getProductHost() + ":" + port + "/product";
		return this.restTemplate.postForObject(url, product, Product.class);
	}
	
	private Product getProduct(String id) {
		String url = StoreConfig.getProductHost() + ":" + port + "/product?id="+id;
		return this.restTemplate.getForObject(url, Product.class);
	}

}
