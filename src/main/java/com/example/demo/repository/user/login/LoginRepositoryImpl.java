package com.example.demo.repository.user.login;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class LoginRepositoryImpl implements LoginRepository {

	private final JdbcTemplate jdbcTemplate;
	@Override
	public boolean isLogin(String userName, String password) {
		
		String isLoginSql = "SELECT COUNT(*) FROM users WHERE user_name = ? AND password = ?";
		
		int count = jdbcTemplate.queryForObject(isLoginSql, Integer.class, userName, password);
		
		if(count == 1) {
			return true;
		}
		
		return false;
	}

}
