package com.spring.jpa.SpringBootEcomerce.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot.product.repository.ProductRepository;
import com.spring.jpa.SpringBootEcomerce.entity.Orders;
import com.spring.jpa.SpringBootEcomerce.entity.Product;
import com.spring.jpa.SpringBootEcomerce.entity.User;
import com.spring.jpa.SpringBootEcomerce.repository.OrderRepository;
import com.spring.jpa.SpringBootEcomerce.repository.UserRepository;
import com.spring.jpa.SpringBootEcomerce.service.OrderService;

import dto.OrderRequest;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
    
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;	
	
	@Override
	public Orders placeOrder(Orders order,int userId) {
	Optional<User> op=	userRepository.findById(userId);
	if(op.isPresent()) {
	User user=	op.get();
	order.setUser(user);
	}
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
