package com.example.demo.repository.admin.edit.game;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.GameDto;
import com.example.demo.repository.admin.edit.team.AdminEditTeamRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AdminEditGameRepositoryImpl implements AdminEditGameRepository {

	private final JdbcTemplate jdbcTemplate;
	private final AdminEditTeamRepository teamRepository;
	
	@Override
	public String insertGame(GameDto gameDto) {
		
		int homeTeamId = teamRepository.findTeamIdByName(gameDto.getHomeTeamName());
		int awayTeamId = teamRepository.findTeamIdByName(gameDto.getAwayTeamName());
		
		if(homeTeamId == 0 || awayTeamId == 0) {
			return "選択した名前のチーム名が登録されていません";
		}else if(homeTeamId == -1){
			return gameDto.getHomeTeamName() + "というチームが複数あります。";
		}else if(awayTeamId == -1) {
			return gameDto.getAwayTeamName() + "というチームが複数あります。";
		}
		
		String insertGameSql = "INSERT INTO games "
								+ "(home_team_id, away_team_id, game_time, home_score, away_score) "
								+ "VALUES(?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(insertGameSql, homeTeamId, 
										   awayTeamId, 
										   gameDto.getGameTime(), 
										   gameDto.getHomeScore(), 
										   gameDto.getAwayScore());
		gameDto.setGameId(findGameIdByGameDto(gameDto));
		addPlayerRating(gameDto);
		
		return "ゲーム追加成功";
	}

	//player_idとgame_idを引数に全ての選手に渡されたgame_idの試合について評価をデフォルト０にする
	public void addPlayerRating(GameDto gameDto) {
		List<Integer> playerIds = selectPlayersByTeam(teamRepository.findTeamIdByName(gameDto.getHomeTeamName()));
		String addPlayerRatingSql = "INSERT INTO player_game_ratings_avg "
								  + "(game_id, player_id) VALUES (?, ?)";
									
		for(int playerId : playerIds) {
			jdbcTemplate.update(addPlayerRatingSql, gameDto.getGameId(), playerId);
		}
	}
	//指定した試合のホームチームの所属する全選手の取得
	public List<Integer> selectPlayersByTeam(int teamId){
		
		String selectPlayersByGameSql = "SELECT player_id FROM players WHERE team_id = ?";
		return jdbcTemplate.queryForList(selectPlayersByGameSql, Integer.class, teamId);
	}
	
	public int findGameIdByGameDto(GameDto gameDto) {
		
		String findGameIdByGameDtoSql = "SELECT game_id FROM games WHERE "
									  + "home_team_id = ? AND "
									  + "away_team_id = ? AND "
									  + "game_time = ? AND "
									  + "home_score = ? AND "
									  + "away_score = ?";
		
		return jdbcTemplate.queryForObject(findGameIdByGameDtoSql, Integer.class,
												 teamRepository.findTeamIdByName(gameDto.getHomeTeamName()), 
												 teamRepository.findTeamIdByName(gameDto.getAwayTeamName()), 
												 gameDto.getGameTime(), 
												 gameDto.getHomeScore(), 
												 gameDto.getAwayScore());
	}
 
}
