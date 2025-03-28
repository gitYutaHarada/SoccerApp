package com.example.demo.session;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.entity.TeamEntity;

import lombok.Data;

@Data
@Component
@SessionScope
public class TeamListSession {

	private List<TeamEntity> teamList;

	public void setFromDto(List<TeamEntity> teamList) {
		this.teamList = teamList;
	}
	
}
