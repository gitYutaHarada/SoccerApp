package com.example.demo.service.user.login;

import org.springframework.stereotype.Service;

import com.example.demo.repository.user.login.LoginRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

	private final LoginRepository repository;
	
	@Override
	public boolean isLogin(String userName, String password) {
		
		return repository.isLogin(userName, password);

	}
}
