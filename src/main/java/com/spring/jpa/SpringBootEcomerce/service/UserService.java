package com.spring.jpa.SpringBootEcomerce.service;

import java.util.List;

import com.spring.jpa.SpringBootEcomerce.entity.User;

public interface UserService {

	User registerUser(User user);

	User getUser(int userId);

	User deleteUser(int userId);

	List<User> getAllUser();

	User updateUser(User user, int userId);

}
