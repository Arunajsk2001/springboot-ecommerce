package com.spring.jpa.SpringBootEcomerce.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jpa.SpringBootEcomerce.entity.Product;
import com.spring.jpa.SpringBootEcomerce.repository.ProductRepository;
import com.spring.jpa.SpringBootEcomerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product registerProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
	List<Product> product=	productRepository.findAll();
	if(product==null) {
		return null;
	}else {
		return product;
	}
	}

	@Override
	public Product getProduct(int productId) {
	Optional<Product> op=	productRepository.findById(productId);
	if(op.isPresent()) {
	Product product=	op.get();
	return product;
	}else {
		return null;
	}
	}

	@Override
	public Product deleteProduct(int productId) {
		Optional<Product> op=	productRepository.findById(productId);
		if(op.isPresent()) {
		Product product=op.get();
		productRepository.delete(product);
		return product;
		}else {
			return null;
		}
		
	}

	@Override
	public Product updateProduct(Product product, int productId) {
	Optional<Product> op=	productRepository.findById(productId);
	if(op.isPresent()) {
		Product exProduct=op.get();
		exProduct.setProductName(product.getProductName());
		exProduct.setProductPrice(product.getProductPrice());
		exProduct.setProductQnty(product.getProductQnty());
		return productRepository.save(exProduct);
	}else {
		return null;
	}
	}
	
	
	
	
	
	
	
	
}
