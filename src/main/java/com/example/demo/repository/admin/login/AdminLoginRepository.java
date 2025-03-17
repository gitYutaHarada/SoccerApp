package com.example.demo.repository.admin.login;

import com.example.demo.dto.UserDto;

public interface AdminLoginRepository {
	
	boolean isAdmin(UserDto userDto);
}
