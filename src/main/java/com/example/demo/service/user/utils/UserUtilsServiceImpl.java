package com.example.demo.service.user.utils;

import org.springframework.stereotype.Service;

import com.example.demo.repository.user.utils.UserUtilsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserUtilsServiceImpl implements UserUtilsService {

	private final UserUtilsRepository repository;

	@Override
	public int findUserIdByUserName(String userName) {
		
		return repository.findUserIdByUserName(userName);
	}
	
}
