package com.softtek.jpa.services;

import java.util.List;

import com.softtek.jpa.domain.User;

public interface UserService {
	
	public List<User> userList();
	public User user(String username);
	public boolean update(User user);
	public boolean newUser(User user);
	public boolean deleteUser(User user);

}
