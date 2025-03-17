package com.example.demo.service.admin.edit.game;

import org.springframework.stereotype.Service;

import com.example.demo.dto.GameDto;
import com.example.demo.repository.admin.edit.game.AdminEditGameRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminEditGameServiceImpl implements AdminEditGameService {

	private final AdminEditGameRepository repository;
	
	@Override
	public String insertGame(GameDto gameDto) {
		
		return repository.insertGame(gameDto);
		
	}

}
