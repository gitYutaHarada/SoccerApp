package com.example.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.UserDto;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CreateUserRepositoryImpl implements CreateUserRepository{

	private final JdbcTemplate jdbcTemplate;

	@Override
	public boolean isUserNameUnique(UserDto userDto) {
		
		String isUserNameUniqueSql = "SELECT COUNT(*) FROM users WHERE user_name = ?";
		
		int count = jdbcTemplate.queryForObject(isUserNameUniqueSql, Integer.class, userDto.getUserName());
		
		if(count > 0) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean isCreateUser(UserDto userDto) {
		
		String createUserSql = "INSERT INTO users (user_name, password, role) VALUES(?, ?, 'user')";
		
		int count = jdbcTemplate.update(createUserSql, userDto.getUserName(), userDto.getPassword());
		
		return count > 0;
	}
}
