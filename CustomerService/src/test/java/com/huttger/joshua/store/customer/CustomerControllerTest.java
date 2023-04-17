package com.huttger.joshua.store.customer;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.huttger.joshua.store.customer.data.Customer;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Value(value = "${local.server.port}")
	private int port;

	@Test
	void testPostAndGet() {
		Customer testCustomer = new Customer(12344, "myname");
		assertThat(postCustomer(testCustomer)).isEqualTo(testCustomer);
		assertThat(getCustomer(testCustomer.getId())).isEqualTo(testCustomer);
	}

	private Customer postCustomer(Customer customer) {
		String url = StoreConfig.getCustomerHost() + ":" + port + "/customer";
		return this.restTemplate.postForObject(url, customer, Customer.class);
	}

	private Customer getCustomer(int id) {
		String url = StoreConfig.getCustomerHost() + ":" + port + "/customer?id=" + id;
		return this.restTemplate.getForObject(url, Customer.class);
	}
}
