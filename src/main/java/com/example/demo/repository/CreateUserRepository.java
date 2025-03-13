package com.example.demo.repository;

import com.example.demo.dto.UserDto;

public interface CreateUserRepository {

	boolean isUserNameUnique(UserDto userDto);
	
	boolean isCreateUser(UserDto userDto);
}
