package com.example.demo.repository.user.utils;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserUtilsRepositoryImpl implements UserUtilsRepository {

	private final JdbcTemplate jdbcTemplate;

	@Override
	public int findUserIdByUserName(String userName) {

		String findUserIdByUserNameSql = "SELECT user_id FROM users WHERE user_name = ?";

		List<Integer> userIdList = jdbcTemplate.queryForList(findUserIdByUserNameSql,
				Integer.class,
				userName);

		if (userIdList.isEmpty() || userIdList.size() != 1) {
			return 0;
		}

		return userIdList.get(0);
	}

	@Override
	public String findUserNameByUserId(int userId) {
		
		String findUserNameByUserIdSql = "SELECT user_name FROM users WHERE user_id = ?";

		List<String> userNameList = jdbcTemplate.queryForList(findUserNameByUserIdSql,
				String.class,
				userId);

		if (userNameList.isEmpty() || userNameList.size() != 1) {
			return "miss";
		}

		return userNameList.get(0);
	}



}
