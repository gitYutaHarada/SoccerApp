package com.example.demo.service.admin.login;

import com.example.demo.dto.UserDto;

public interface AdminLoginService {

	boolean isAdmin(UserDto userDto);
}
