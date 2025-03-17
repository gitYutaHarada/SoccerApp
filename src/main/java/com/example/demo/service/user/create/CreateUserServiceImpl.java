package com.example.demo.service.user.create;

import org.springframework.stereotype.Service;

import com.example.demo.repository.user.create.CreateUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateUserServiceImpl implements CreateUserService{

	private final CreateUserRepository repository;
	
	@Override
	public boolean isUserNameUnique(String userName) {

		return repository.isUserNameUnique(userName);
	}

	@Override
	public boolean isCreateUser(String userName, String password) {
	
		return repository.isCreateUser(userName, password);
	}
}
