package com.example.demo.repository.game;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.GameEntity;
import com.example.demo.repository.admin.edit.team.AdminEditTeamRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class GameBoardRepositoryImpl implements GameBoardRepository {
	
	private final JdbcTemplate jdbcTemplate;
	private final AdminEditTeamRepository teamRepository;
	
	@Override
	public List<GameEntity> setGameEntity(String teamName) {
		
		int teamId = teamRepository.findTeamIdByName(teamName);
		
		String setGameEntitySql = "SELECT * FROM games WHERE home_team_id = ?";
		List<Map<String, Object>> gameList = jdbcTemplate.queryForList(setGameEntitySql, teamId);
		
		List<GameEntity> gameEntityList = new ArrayList<>();
		for(Map<String, Object> game : gameList) {
			GameEntity gameEntity = new GameEntity();
			gameEntity.setHomeTeamId((int)game.get("home_team_id"));
			gameEntity.setAwayTeamId((int)game.get("away_team_id"));
			gameEntity.setGameTime((LocalDateTime)game.get("game_time"));
			gameEntity.setHomeScore((int)game.get("home_team_score"));
			gameEntity.setHomeScore((int)game.get("home_team_score"));
			gameEntityList.add(gameEntity);
		}
		
		return gameEntityList;
	}

}
