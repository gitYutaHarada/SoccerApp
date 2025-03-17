package com.example.demo.repository.admin.edit.team;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.TeamDto;
import com.example.demo.entity.TeamEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AdminEditTeamRepositoryImpl implements AdminEditTeamRepository {

	private final JdbcTemplate jdbcTemplate;
	
	public List<TeamEntity> findAllTeam(){
		
		String findAllTeamSql = "SELECT * FROM teams";
		
		List<Map<String, Object>> teamList = jdbcTemplate.queryForList(findAllTeamSql);
		List<TeamEntity> result = new ArrayList<>(); 
		
		for(Map<String, Object> team : teamList) {
			TeamEntity teamEntity = new TeamEntity();
			teamEntity.setTeamId((int)team.get("team_id"));
			teamEntity.setTeamName((String)team.get("team_name"));
			teamEntity.setTeamImageName((String)team.get("team_image_name"));
			teamEntity.setTeamImageType((String)team.get("team_image_type"));
			String base64TeamImage = Base64.getEncoder().encodeToString((byte[])team.get("team_image"));
			teamEntity.setTeamImage(base64TeamImage);
			result.add(teamEntity);
		}
		
		return result;
		
	}

	@Override
	public void insertTeam(TeamDto teamDto) {
		
		String insertTeamSql = "INSERT INTO teams (team_name, team_image_name, team_image_type, team_image) VALUES(?, ?, ?, ?)";
		MultipartFile teamImage = teamDto.getTeamImage();
		try {
			jdbcTemplate.update(insertTeamSql, 
					teamDto.getTeamName(), 
					teamImage.getOriginalFilename(), 
					teamImage.getContentType(), 
					teamImage.getBytes());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public int findTeamIdByName(String teamName) {
		
		String findIdByTeamNameSql = "SELECT team_id FROM teams WHERE team_name = ?";
		
		List<Integer> idList = jdbcTemplate.queryForList(findIdByTeamNameSql, Integer.class, teamName);
		
		//IDが存在する
		if(idList.size() == 1) 
			return idList.get(0);
		//IDが存在しないとき０
		else if(idList.isEmpty()) 
			return 0;
		//IDが複数ある時-1
		else 
			return -1;
		
	}

	@Override
	public String findTeamById(int teamId) {
		String findTeamByIdSql = "SELECT team_name FROM teams WHERE team_id = ?";
		
		List<String> teamNameList = jdbcTemplate.queryForList(findTeamByIdSql, String.class, teamId);
		
		//IDが存在する
		if(teamNameList.size() == 1) 
			return teamNameList.get(0);
		//IDが存在しないとき０
		else if(teamNameList.isEmpty()) 
			return "miss";
		//IDが複数ある時-1
		else 
			return "miss";
	}
}
