package com.spring.jpa.SpringBootEcomerce.service;

import java.util.List;

import com.spring.jpa.SpringBootEcomerce.entity.Orders;

public interface OrderService {

	Orders placeOrder(Orders order);

	List<Orders> fetchAllOrders();

	Orders fetchOrderById(int orderId);

	Orders deleteOrderById(int orderId);

	Orders updateOrder(Orders order, int orderId);

}
