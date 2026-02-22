package com.spring.jpa.SpringBootEcomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpa.SpringBootEcomerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
