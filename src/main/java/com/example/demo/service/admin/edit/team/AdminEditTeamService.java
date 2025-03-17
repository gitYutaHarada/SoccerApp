package com.example.demo.service.admin.edit.team;

import java.util.List;

import com.example.demo.dto.TeamDto;
import com.example.demo.entity.TeamEntity;

public interface AdminEditTeamService {

	List<TeamEntity> findAllTeam();
	
	void insertTeam(TeamDto teamDto);
	
	int findTeamIdByName(String teamName);
}
