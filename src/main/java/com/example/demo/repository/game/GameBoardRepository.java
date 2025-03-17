package com.example.demo.repository.game;

import java.util.List;

import com.example.demo.entity.GameEntity;

public interface GameBoardRepository {

	List<GameEntity> setGameEntity(String teamName);
}
