package com.spring.jpa.SpringBootEcomerce.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jpa.SpringBootEcomerce.entity.Orders;
import com.spring.jpa.SpringBootEcomerce.repository.OrderRepository;
import com.spring.jpa.SpringBootEcomerce.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Orders placeOrder(Orders order) {
		return orderRepository.save(order);
	}

	@Override
	public List<Orders> fetchAllOrders() {
	List<Orders>	orders=orderRepository.findAll();
	if(orders==null) {
		return null;
	}else {
		return orders;
	}
	}

	@Override
	public Orders fetchOrderById(int orderId) {
	Optional<Orders> op=   orderRepository.findById(orderId);
	if(op.isPresent()) {
	Orders order=	op.get();
	return order;
	}else {
		return null;
	}
	}

	@Override
	public Orders deleteOrderById(int orderId) {
	Optional<Orders> op=	orderRepository.findById(orderId);
	if(op.isPresent()) {
	Orders order=	op.get();
	orderRepository.delete(order);
	return order;
	}else {
		return null;
	}
	}

	@Override
	public Orders updateOrder(Orders order, int orderId) {
	Optional<Orders> op=	orderRepository.findById(orderId);
	if(op.isPresent()) {
	Orders exorder=	op.get();
	exorder.setOrderDate(order.getOrderDate());
	exorder.setOrderStatus(order.getOrderStatus());
	exorder.setTotalAmount(order.getTotalAmount());
	exorder.setPaymentStatus(order.getPaymentStatus());
	exorder.setPaymentMethod(order.getPaymentMethod());
	return orderRepository.save(exorder);
	}else {
		return null;
	}
	}
	

}
