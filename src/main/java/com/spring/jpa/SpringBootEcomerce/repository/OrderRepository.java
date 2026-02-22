package com.spring.jpa.SpringBootEcomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpa.SpringBootEcomerce.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
