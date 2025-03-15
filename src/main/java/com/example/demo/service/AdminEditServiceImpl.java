package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.TeamDto;
import com.example.demo.entity.TeamEntity;
import com.example.demo.repository.AdminEditRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminEditServiceImpl implements AdminEditService {

	private final AdminEditRepository repository;
	
	@Override
	public List<TeamEntity> findAllTeam() {
		
		return repository.findAllTeam();
	}
	
	@Override
	public void insertTeam(TeamDto teamDto) {

		repository.insertTeam(teamDto);
	}


}
