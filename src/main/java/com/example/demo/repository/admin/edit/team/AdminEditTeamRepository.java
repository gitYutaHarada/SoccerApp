package com.example.demo.repository.admin.edit.team;

import java.util.List;

import com.example.demo.dto.TeamDto;
import com.example.demo.entity.TeamEntity;

public interface AdminEditTeamRepository {

	List<TeamEntity> findAllTeam();
	
	void insertTeam(TeamDto teamDto);
	
	public int findTeamIdByName(String teamName);
}
