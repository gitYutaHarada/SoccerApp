package com.example.demo.repository.user.utils;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.admin.edit.team.AdminEditTeamRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserUtilsRepositoryImpl implements UserUtilsRepository {

	private final JdbcTemplate jdbcTemplate;
	private final AdminEditTeamRepository teamRepository;

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



}
