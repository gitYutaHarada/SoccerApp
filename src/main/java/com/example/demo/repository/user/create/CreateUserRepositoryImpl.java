package com.example.demo.repository.user.create;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CreateUserRepositoryImpl implements CreateUserRepository{

	private final JdbcTemplate jdbcTemplate;

	@Override
	public boolean isUserNameUnique(String userName) {
		
		String isUserNameUniqueSql = "SELECT COUNT(*) FROM users WHERE user_name = ?";
		
		int count = jdbcTemplate.queryForObject(isUserNameUniqueSql, Integer.class, userName);
		
		if(count > 0) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean isCreateUser(String userName, String password) {
		
		String createUserSql = "INSERT INTO users (user_name, password, role) VALUES(?, ?, 'user')";
		
		int count = jdbcTemplate.update(createUserSql, userName, password);
		
		return count > 0;
	}
}
