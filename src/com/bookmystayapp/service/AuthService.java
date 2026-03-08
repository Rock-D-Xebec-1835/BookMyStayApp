package com.bookmystayapp.service;

import java.awt.desktop.UserSessionEvent;

import com.bookmystayapp.exception.AuthException;
import com.bookmystayapp.exception.UserException;
import com.bookmystayapp.model.User;
import com.bookmystayapp.repository.UserRepository;
import com.bookmystayapp.model.*;

public class AuthService {
	private UserRepository userRepository;
	public AuthService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void registerUser(String email, String password, Role role) {
		if(email == null || email.isBlank()) throw new AuthException("Email cannot be null");
		if(!ValidationService.isValidEmail(email)) throw new AuthException("Invalid email format");
		if(password == null || password.isBlank()) throw new AuthException("Password cannot be null");
		if(!ValidationService.isStrongPassword(password)) throw new AuthException("Password too weak. Must have atleast 1 uppercase, 1 lowercase, 1 digit and 1 special character");
		if(userRepository.userExists(email)) throw new AuthException("User already exists");
		User user = new User(email, PasswordService.hashPassword(password), role);
		userRepository.addUser(user);
	}
	
	public User login(String email, String password) {
		if(!userRepository.validateUser(email, password)) throw new AuthException("Invalid login credentials");
	return userRepository.getUserByEmail(email);
	}
	
	
}
