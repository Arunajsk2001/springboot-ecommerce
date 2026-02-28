package com.spring.jpa.SpringBootEcomerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.SpringBootEcomerce.entity.Orders;
import com.spring.jpa.SpringBootEcomerce.service.OrderService;
import com.spring.jpa.SpringBootEcomerce.utility.ResponseStructure;

import dto.OrderRequest;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/placeorder/{userId}")
	public ResponseStructure<Orders> placeOrder(@RequestBody Orders order, @PathVariable int userId){
	 order =	orderService.placeOrder(order,userId);
	return ResponseStructure.create(HttpStatus.CREATED.value(), "order has been placed", order);
	}
	
	@GetMapping("/fetchAllOrder")
	public ResponseStructure<List<Orders>> fetchAllOrders(){
	List<Orders> orders=	orderService.fetchAllOrders();
	return ResponseStructure.create(HttpStatus.OK.value(), "fetched All Orders", orders);
	}
	
	@GetMapping("/getOrder/{orderId}")
	public ResponseEntity<ResponseStructure<Orders>> fetchOrderById(@PathVariable int orderId){
	Orders order=	orderService.fetchOrderById(orderId);
	return ResponseEntity
			.status(HttpStatus.OK)
			.body(ResponseStructure.create(HttpStatus.OK.value(), "order is fetched by Id", order));
	}
	
	@DeleteMapping("/deleteOrder/{orderId}")
	public ResponseStructure<Orders> deleteOrderById(@PathVariable int orderId){
	Orders order=	orderService.deleteOrderById(orderId);
	return ResponseStructure.create(HttpStatus.OK.value(), "Order has been deleted from database", order);
	}
	
	@PutMapping("/orderUpdate/{orderId}")
	public ResponseStructure<Orders> updateOrder(@RequestBody Orders order,@PathVariable int orderId){
	order=	orderService.updateOrder(order,orderId);
	return ResponseStructure.create(HttpStatus.OK.value(), "order has been updated", order);
	}
}
