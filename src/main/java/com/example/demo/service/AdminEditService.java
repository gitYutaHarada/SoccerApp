package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.TeamDto;
import com.example.demo.entity.TeamEntity;

public interface AdminEditService {

	List<TeamEntity> findAllTeam();
	
	void insertTeam(TeamDto teamDto);
	
}
