package com.example.demo.service.admin.edit.team;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.TeamDto;
import com.example.demo.entity.TeamEntity;
import com.example.demo.repository.admin.edit.team.AdminEditTeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminEditTeamServiceImpl implements AdminEditTeamService {

	private final AdminEditTeamRepository repository;
	
	@Override
	public List<TeamEntity> findAllTeam() {
		
		return repository.findAllTeam();
	}
	
	@Override
	public void insertTeam(TeamDto teamDto) {

		repository.insertTeam(teamDto);
	}

	@Override
	public int findTeamIdByName(String teamName) {
		
		return repository.findTeamIdByName(teamName);
	}


}
