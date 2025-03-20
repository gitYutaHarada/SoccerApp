package com.example.demo.service.user.utils;

public interface UserUtilsService {

	int findUserIdByUserName(String userName);
	
	String findUserNameByUserId(int userId);
}
