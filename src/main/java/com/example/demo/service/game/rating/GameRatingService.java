package com.example.demo.service.game.rating;

import java.util.List;

import com.example.demo.dto.PlayerRatingAvgDto;

public interface GameRatingService {

	List<PlayerRatingAvgDto> getGamePlayerRatingAvg();
}
