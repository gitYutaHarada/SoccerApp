package com.example.demo.service.admin.edit.player;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.PlayerDto;
import com.example.demo.entity.PlayerEntity;
import com.example.demo.repository.admin.edit.player.AdminEditPlayerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminEditPlayerServiceImpl implements AdminEditPlayerService {

	private final AdminEditPlayerRepository repository;
	
	@Override
	public List<PlayerEntity> findPlayerByTeamName(String teamName) {
		
		return repository.findPlayerByTeamName(teamName);
	}

	@Override
	public String addPlayer(PlayerDto playerDto) {
		
		return repository.addPlayer(playerDto);
	}

}
