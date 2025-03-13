package com.example.demo.service;

import com.example.demo.dto.UserDto;

public interface CreateUserService {

	boolean isUserNameUnique(UserDto userDto);
	
	boolean isCreateUser(UserDto userDto);
	
}
