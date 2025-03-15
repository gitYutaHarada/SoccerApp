package com.example.demo.repository;

import java.util.List;

import com.example.demo.dto.TeamDto;
import com.example.demo.entity.TeamEntity;

public interface AdminEditRepository {

	List<TeamEntity> findAllTeam();
	
	void insertTeam(TeamDto teamDto);
}
