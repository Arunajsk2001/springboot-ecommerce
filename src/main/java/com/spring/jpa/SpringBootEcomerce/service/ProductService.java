package com.spring.jpa.SpringBootEcomerce.service;

import java.util.List;

import com.spring.jpa.SpringBootEcomerce.entity.Product;

public interface ProductService {

	 Product registerProduct(Product product);

	List<Product> getAllProduct();

	 Product getProduct(int productId);

	Product deleteProduct(int productId);

	Product updateProduct(Product product, int productId);
	

}
