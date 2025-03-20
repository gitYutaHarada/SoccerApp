package com.example.demo.service.game.board;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.GameDto;
import com.example.demo.repository.game.board.GameBoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameBoardServiceImpl implements GameBoardService {

	private final GameBoardRepository repository;

	@Override
	public List<GameDto> setAllGameDto() {
		
		return repository.setAllGameDto();
		
	}
	
}
