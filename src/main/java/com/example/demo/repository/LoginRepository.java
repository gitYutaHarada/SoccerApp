package com.example.demo.repository;

import com.example.demo.dto.UserDto;

public interface LoginRepository {

	boolean isLogin(UserDto isLoginDto);

}
