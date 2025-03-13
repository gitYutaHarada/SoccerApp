package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.repository.CreateUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateUserServiceImpl implements CreateUserService{

	private final CreateUserRepository repository;
	
	@Override
	public boolean isUserNameUnique(UserDto userDto) {

		return repository.isUserNameUnique(userDto);
	}

	@Override
	public boolean isCreateUser(UserDto userDto) {
	
		return repository.isCreateUser(userDto);
	}
}
