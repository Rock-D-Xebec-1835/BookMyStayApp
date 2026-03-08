package com.bookmystayapp.repository;
import com.bookmystayapp.exception.UserException;
import com.bookmystayapp.model.*;
import com.bookmystayapp.model.Role;
import com.bookmystayapp.service.PasswordService;

import java.util.HashMap;

public class UserRepository {
		private HashMap<String, User> users;
	public UserRepository() {
		this.users = new HashMap<String, User>();
		String adminHash = PasswordService.hashPassword("Admin@123");
		User admin = new User("admin@gmail.com", adminHash, Role.ADMIN);
		users.put("admin@gmail.com", admin);
	}
	
	public void addUser(User user) {
		if(user == null) throw new UserException("User cannot be null");
		users.put(user.getEmail(), user);
	}
	
	public User getUserByEmail(String email) {
		if(email == null || email.isBlank()) throw new UserException("Email cannot be null");
		User user = users.get(email);
		if(user == null) throw new UserException("User not found");
		return user;
	}
	
	public boolean validateUser(String email, String password) {
		if(email == null || email.isBlank()) throw new UserException("Email cannot be null");
		if(password == null || password.isBlank()) throw new UserException("Password cannot be null");
		
		User user = users.get(email);
		if(user == null) return false;
		String hash = PasswordService.hashPassword(password);
		return user.getPassword().equals(hash);
	}
	
	public boolean userExists(String email) {
		if(email == null || email.isBlank()) throw new UserException("Email cannot be null");
		return users.containsKey(email);
	}
	
}

