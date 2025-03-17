package com.example.demo.service.game;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.GameEntity;
import com.example.demo.repository.game.GameBoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameBoardServiceImpl implements GameBoardService {

	private final GameBoardRepository repository;

	@Override
	public List<GameEntity> setGameEntity(String teamName) {
		
		return repository.setGameEntity(teamName);
		
	}
	
}
