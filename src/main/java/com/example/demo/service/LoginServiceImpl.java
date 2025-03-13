package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.repository.LoginRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

	private final LoginRepository repository;
	
	@Override
	public boolean isLogin(UserDto isLoginDto) {
		
		return repository.isLogin(isLoginDto);

	}
}
