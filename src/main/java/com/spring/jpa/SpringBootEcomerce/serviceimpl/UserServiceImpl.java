package com.spring.jpa.SpringBootEcomerce.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.jpa.SpringBootEcomerce.SpringBootEcomerceApplication;
import com.spring.jpa.SpringBootEcomerce.entity.User;
import com.spring.jpa.SpringBootEcomerce.repository.UserRepository;
import com.spring.jpa.SpringBootEcomerce.service.UserService;

@Service
public class UserServiceImpl implements UserService{

   
	@Autowired
	private UserRepository userRepository;

    

	@Override
	public User registerUser(User user) {
	       return userRepository.save(user);
	}

	@Override
	public User getUser(int userId) {
		 Optional<User>op= userRepository.findById(userId);
		 if(op.isPresent()) {
			User user= op.get();
			return user;
		 }else {
		return null;
		 }
	}

	@Override
	public User deleteUser(int userId) {
		Optional<User>op=    userRepository.findById(userId);
		if(op.isPresent()) {
		User user=	op.get();
	    userRepository.delete(user);
	    return user;
		}else {
			return null;
		}
	}

	@Override
	public List<User> getAllUser() {
	List<User> user=	userRepository.findAll();
	if(user.isEmpty()) {
		return null;
	}else {
		return user;
	}
	}

	@Override
	public User updateUser(User user, int userId) {
	Optional<User> op=	userRepository.findById(userId);
	if(op.isPresent()) {
	User exUser=	op.get();
	exUser.setUserName(user.getUserName());
	exUser.setUserEmail(user.getUserEmail());
	exUser.setUserPassword(user.getUserPassword());
	exUser.setUserPhone(user.getUserPhone());
	exUser.setUserRole(user.getUserRole());
	exUser.setUserAddress(user.getUserAddress());
	userRepository.save(exUser);
	return exUser;
	}else {
		return null;
	}
		
	}
	
   
}
