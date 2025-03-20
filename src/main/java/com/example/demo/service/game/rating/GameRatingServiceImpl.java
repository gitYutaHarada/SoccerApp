package com.example.demo.service.game.rating;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.PlayerRatingAvgDto;
import com.example.demo.repository.game.rating.GameRatingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameRatingServiceImpl implements GameRatingService {

	private final GameRatingRepository repository;

	@Override
	public List<PlayerRatingAvgDto> getGamePlayerRatingAvg() {
		
		return repository.getGamePlayerRatingAvg();
	}
	
	
}
