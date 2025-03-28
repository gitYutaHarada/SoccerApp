package com.example.demo.repository.game.rating;

import java.util.List;

import com.example.demo.dto.PlayerRatingAvgDto;

public interface GameRatingRepository {

	List<PlayerRatingAvgDto> getGamePlayerRatingAvgDtoList();
}
