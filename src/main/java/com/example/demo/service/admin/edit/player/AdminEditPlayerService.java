package com.example.demo.service.admin.edit.player;

import java.util.List;

import com.example.demo.dto.PlayerDto;
import com.example.demo.entity.PlayerEntity;

public interface AdminEditPlayerService {

	public List<PlayerEntity> findPlayerByTeamName(String teamName);
	
	public String addPlayer(PlayerDto playerDto);
}
