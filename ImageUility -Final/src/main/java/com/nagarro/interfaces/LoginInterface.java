package com.nagarro.interfaces;
import com.nagarro.model.User;

public interface LoginInterface {
	 Boolean userAuthentication(String username, String password);

	    User getUserDetails(String username);

}
