package com.example.demo.service;

import com.example.demo.dto.UserDto;

public interface AdminLoginService {

	boolean isAdmin(UserDto userDto);
}
