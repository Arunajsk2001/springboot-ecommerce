package com.spring.jpa.SpringBootEcomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpa.SpringBootEcomerce.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserName(String userName);
}
