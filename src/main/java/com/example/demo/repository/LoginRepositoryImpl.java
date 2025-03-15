package com.example.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.UserDto;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class LoginRepositoryImpl implements LoginRepository {

	private final JdbcTemplate jdbcTemplate;
	@Override
	public boolean isLogin(UserDto userDto) {
		
		String isLoginSql = "SELECT COUNT(*) FROM users WHERE user_name = ? AND password = ?";
		
		int count = jdbcTemplate.queryForObject(isLoginSql, Integer.class, userDto.getUserName(), userDto.getPassword());
		
		if(count == 1) {
			return true;
		}
		
		return false;
	}

}
