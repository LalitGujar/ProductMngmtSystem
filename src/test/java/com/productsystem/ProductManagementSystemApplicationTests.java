package com.productsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import com.demo.productsystem.ProductManagementSystemApplication;

@SpringBootTest(classes = ProductManagementSystemApplication.class)
class ProductManagementSystemApplicationTests {

	@Test
	void contextLoads() {
	}
	
	  @Configuration
	    static class TestConfig {
	    }

}
