package com.example.demo.repository.user.utils;

public interface UserUtilsRepository {

	int findUserIdByUserName(String userName);
	
	String findUserNameByUserId(int userId);
		
}
