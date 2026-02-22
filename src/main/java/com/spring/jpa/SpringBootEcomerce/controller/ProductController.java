package com.spring.jpa.SpringBootEcomerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.SpringBootEcomerce.entity.Product;
import com.spring.jpa.SpringBootEcomerce.service.ProductService;
import com.spring.jpa.SpringBootEcomerce.utility.ResponseStructure;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/register-Product")
	public ResponseEntity<ResponseStructure<Product>> registerProduct(@RequestBody Product product) {

	    product = productService.registerProduct(product);

	    return new ResponseEntity<>(
	            ResponseStructure.create(
	                    HttpStatus.CREATED.value(),
	                    "Product added successfully",
	                    product
	            ),
	            HttpStatus.CREATED
	    );
	}
    
	@GetMapping("/findAllProducts")
	public ResponseStructure<List<Product>> getAllProduct(){
		List<Product> product= productService.getAllProduct();
		return ResponseStructure.create(HttpStatus.FOUND.value(), "found All Product",product);
	}

	@GetMapping("/get-product/{productId}")
	public ResponseEntity<ResponseStructure<Product>> getProduct(@PathVariable int productId) {
		Product product= productService.getProduct(productId);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(ResponseStructure.create(HttpStatus.FOUND.value(),"Product found", product));
	}

	@DeleteMapping("deleteProduct/{productId}")
	public ResponseStructure<Product>  deleteProduct(@PathVariable int productId) {
		Product product= productService.deleteProduct(productId);
		return ResponseStructure.create(HttpStatus.OK.value(), "Product deleted", product);
	}

	@PutMapping("/updateProduct/{productId}")
	public ResponseStructure<Product> updateProduct(@RequestBody Product product, @PathVariable int productId) {
		product= productService.updateProduct(product,productId);
		return ResponseStructure.create(HttpStatus.OK.value(), "Product updated", product);
	}



}
