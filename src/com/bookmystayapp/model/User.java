package com.bookmystayapp.model;

public class User {
	private String email;
	private String hashedPassword;
	private final Role role;
	
	public User(String email, String hashedPassword, Role role) {
		this.email = email;
		this.hashedPassword = hashedPassword;
		this.role = role;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.hashedPassword;
	}
	
	public Role getRole() {
		return this.role;
	}
}
