package com.example.demo.repository;

import com.example.demo.dto.UserDto;

public interface AdminLoginRepository {
	
	boolean isAdmin(UserDto userDto);
}
