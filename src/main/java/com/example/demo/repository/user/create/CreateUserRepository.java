package com.example.demo.repository.user.create;

public interface CreateUserRepository {

	boolean isUserNameUnique(String userName);
	
	boolean isCreateUser(String userName, String password);
}
