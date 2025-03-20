package com.example.demo.repository.game.board;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.GameDto;
import com.example.demo.repository.admin.edit.team.AdminEditTeamRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class GameBoardRepositoryImpl implements GameBoardRepository {
	
	private final JdbcTemplate jdbcTemplate;
	private final AdminEditTeamRepository teamRepository;
	
	@Override
	public List<GameDto> setAllGameDto() {
		
		
		String setGameDtoSql = "SELECT * FROM games";
		List<Map<String, Object>> gameList = jdbcTemplate.queryForList(setGameDtoSql);
		
		List<GameDto> gameDtoList = new ArrayList<>();
		for(Map<String, Object> game : gameList) {
			GameDto gameDto = new GameDto();
			gameDto.setGameId((int)game.get("game_id"));
			gameDto.setHomeTeamName(teamRepository.findTeamById((int)game.get("home_team_id")));
			gameDto.setAwayTeamName(teamRepository.findTeamById((int)game.get("away_team_id")));
			gameDto.setGameTime((LocalDateTime)game.get("game_time"));
			gameDto.setHomeScore(((int)game.get("home_score")));
			gameDto.setAwayScore(((int)game.get("away_team_id")));

			gameDtoList.add(gameDto);
		}
		
		return gameDtoList;
	}

	@Override
	public String findTeamNameByGameId(int gameId, String homeOrAway) {
		
		String homeOrAwayId = "";
		if("home".equals(homeOrAway)) {
			homeOrAwayId = "home_team_id";

		}else if("away".equals(homeOrAway)) {
			homeOrAwayId = "away_tean_id";
		}
		String findTeamNameByGameIdSql = "SELECT " + homeOrAwayId + " FROM games WHERE game_id = ?";
		int teamId = jdbcTemplate.queryForObject(findTeamNameByGameIdSql, 
												 Integer.class,
												 gameId);
		return teamRepository.findTeamById(teamId);
	}

}
