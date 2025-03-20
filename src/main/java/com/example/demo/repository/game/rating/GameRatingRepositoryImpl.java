package com.example.demo.repository.game.rating;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.PlayerRatingAvgDto;
import com.example.demo.repository.admin.edit.player.AdminEditPlayerRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class GameRatingRepositoryImpl implements GameRatingRepository {

	private final JdbcTemplate jdbcTemplate;
	private final AdminEditPlayerRepository playerRepsitory;

	@Override
	public List<PlayerRatingAvgDto> getGamePlayerRatingAvg() {
		
		String getGamePlayerRatingAvgSql = "SELECT * FROM average_ratings";
		List<Map<String, Object>> ratingAvgList = jdbcTemplate.queryForList(getGamePlayerRatingAvgSql);
		List<PlayerRatingAvgDto> result = new ArrayList<>();
		
		for(Map<String, Object> ratingAvg : ratingAvgList) {
			PlayerRatingAvgDto ratingAvgDto = new PlayerRatingAvgDto();
			ratingAvgDto.setGameId((int)ratingAvg.get("game_id"));
			ratingAvgDto.setPlayerName(playerRepsitory.findPlayerNameById((int)ratingAvg.get("player_id")));
			ratingAvgDto.setRatingAvg(((BigDecimal)ratingAvg.get("average_rating")).doubleValue());
			result.add(ratingAvgDto);
		}
		
		return result;
	}
	
	
}
