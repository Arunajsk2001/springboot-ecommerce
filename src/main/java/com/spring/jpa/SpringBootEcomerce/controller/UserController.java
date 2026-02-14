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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.SpringBootEcomerce.entity.User;
import com.spring.jpa.SpringBootEcomerce.service.UserService;
import com.spring.jpa.SpringBootEcomerce.utility.ResponseStructure;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	 
	@PostMapping("/register-user")
	public ResponseEntity<ResponseStructure<User>> registerUser(@RequestBody User user) {

	    user = userService.registerUser(user);

	    return new ResponseEntity<>(
	            ResponseStructure.create(
	                    HttpStatus.CREATED.value(),
	                    "User registered successfully",
	                    user
	            ),
	            HttpStatus.CREATED
	    );
	}

	@GetMapping("/getuser/{userId}")
	public ResponseEntity<ResponseStructure<User>> getUser(@PathVariable int userId) {
		User user= userService.getUser(userId);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(ResponseStructure.create(HttpStatus.FOUND.value(),"user found", user));
	}
	
	@DeleteMapping("deleteuser/{userId}")
	public ResponseStructure<User>  deleteUser(@PathVariable int userId) {
		User user= userService.deleteUser(userId);
		return ResponseStructure.create(HttpStatus.OK.value(), "user deleted", user);
	}
	
	@GetMapping("/findAllUser")
	public ResponseStructure<List<User>> getAllUser(){
		List<User> user= userService.getAllUser();
		return ResponseStructure.create(HttpStatus.FOUND.value(), "found All user",user);
	}
	
	@PutMapping("/updateuser/{userId}")
	public ResponseStructure<User> updateUser(@RequestBody User user, @PathVariable int userId) {
		user= userService.updateUser(user,userId);
		return ResponseStructure.create(HttpStatus.OK.value(), "user updated", user);
	}
	@GetMapping("/findName/{userName}")
	public ResponseStructure<User> getUserByName(@PathVariable String userName){
	User user=	userService.findByName(userName);
	return ResponseStructure.create(HttpStatus.OK.value(), "find the user by name", user);
	}
	
}
