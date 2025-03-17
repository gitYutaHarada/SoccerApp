package com.example.demo.repository.admin.edit.game;

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

		return "ゲーム追加成功";
	}

}
