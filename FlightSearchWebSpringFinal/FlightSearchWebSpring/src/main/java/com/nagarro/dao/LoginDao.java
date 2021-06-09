package com.nagarro.dao;

import com.nagarro.dto.User;

public interface LoginDao {
	
	User getUserDetails(String username);
	
	void updatePassword(String username, String password);

	void signup(User user);
}
