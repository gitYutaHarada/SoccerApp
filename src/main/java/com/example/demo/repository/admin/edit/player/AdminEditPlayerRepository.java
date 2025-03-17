package com.example.demo.repository.admin.edit.player;

import java.util.List;

import com.example.demo.dto.PlayerDto;
import com.example.demo.entity.PlayerEntity;

public interface AdminEditPlayerRepository {

	public List<PlayerEntity> findPlayerByTeamName(String teamName);

	public String addPlayer(PlayerDto playerDto);
	
	public int countPlayer(PlayerDto playerDto);
	
	public int findPlayerId(PlayerDto playerDto);
}
