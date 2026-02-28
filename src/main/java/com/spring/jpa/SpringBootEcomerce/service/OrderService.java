package com.spring.jpa.SpringBootEcomerce.service;

import java.util.List;

import com.spring.jpa.SpringBootEcomerce.entity.Orders;

import dto.OrderRequest;

public interface OrderService {

	Orders placeOrder(Orders order,int userId);

	List<Orders> fetchAllOrders();

	Orders fetchOrderById(int orderId);

	Orders deleteOrderById(int orderId);

	Orders updateOrder(Orders order, int orderId);

}
