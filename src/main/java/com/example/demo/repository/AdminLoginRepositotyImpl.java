package com.example.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.UserDto;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AdminLoginRepositotyImpl implements AdminLoginRepository {

	private final JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean isAdmin(UserDto userDto) {
		
		String isAdminSql = "SELECT COUNT(*) FROM users WHERE user_name = ? AND role = 'admin'";
		
		int count = jdbcTemplate.queryForObject(isAdminSql, Integer.class, userDto.getUserName());
		
		return count == 1;
	}

}
