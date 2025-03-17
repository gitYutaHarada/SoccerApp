package com.example.demo.repository.user.profile;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.UserDto;
import com.example.demo.repository.admin.edit.team.AdminEditTeamRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserProfileRepositoryImpl implements UserProfileRepository {

	private final JdbcTemplate jdbcTemplate;
	private final AdminEditTeamRepository teamRepository;

	@Override
	public String addFavoriteTeam(String teamName, UserDto userDto) {
		int teamId = teamRepository.findTeamIdByName(teamName);
		if(teamId == 0 || teamId == -1) {
			return "このチームはお気に入りに登録できません。";
		}
		
		String addFavoriteTeamSql = "UPDATE users SET favorite_team_id = ? WHERE user_id = ?";
		int countSql = jdbcTemplate.update(addFavoriteTeamSql, teamId, userDto.getUserId());
		if(countSql == 1) {
			return "お気に入り登録できました";
		}
		return "ミスがありました";
	}
	
	@Override
	public void setUserDto(UserDto userDto, String userName) {

		String setUserDtoSql = "SELECT * FROM users WHERE user_name = ?";

		Map<String, Object> userMap = jdbcTemplate.queryForMap(setUserDtoSql, userName);

		userDto.setUserId((int) userMap.get("user_id"));
		userDto.setUserName(userName);
		
		if (userMap.get("favorite_team_id") != null) {
			userDto.setFavoriteTeamName(
					teamRepository.findTeamById((int) userMap.get("favorite_team_id")));
		}

	}
}
