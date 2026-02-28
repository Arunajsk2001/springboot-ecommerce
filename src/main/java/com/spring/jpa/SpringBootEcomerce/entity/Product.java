package com.spring.jpa.SpringBootEcomerce.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private double productPrice;
	private int productQnty;
	
	
	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public int getProductQnty() {
		return productQnty;
	}


	public void setProductQnty(int productQnty) {
		this.productQnty = productQnty;
	}


	public List<Orders> getOrders() {
		return orders;
	}


	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}


	@ManyToMany(mappedBy = "product")
	private List<Orders> orders;
	
}
