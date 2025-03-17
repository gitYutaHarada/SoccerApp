package com.example.demo.service.user.create;

public interface CreateUserService {

	boolean isUserNameUnique(String userName);
	
	boolean isCreateUser(String userName, String password);
	
}
