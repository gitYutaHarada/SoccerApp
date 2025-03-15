package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.repository.AdminLoginRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminLoginServiceImpl implements AdminLoginService {

	private final AdminLoginRepository repository;

	@Override
	public boolean isAdmin(UserDto userDto) {
		
		if(repository.isAdmin(userDto)) {
			return true;
		}
		
		return false;
	}

}
