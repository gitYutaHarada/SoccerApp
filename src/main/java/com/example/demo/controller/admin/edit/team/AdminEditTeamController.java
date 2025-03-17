package com.example.demo.controller.admin.edit.team;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.TeamDto;
import com.example.demo.entity.TeamEntity;
import com.example.demo.service.admin.edit.team.AdminEditTeamService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminEditTeamController {
	
	private final AdminEditTeamService service;
	
	@GetMapping("/team-edit")
	public String teamEdit(Model model) {
		
		List<TeamEntity> teamList = service.findAllTeam();
		
		model.addAttribute("teamList", teamList);
		model.addAttribute("action", "team");
		return "admin-edit";
	}
	
	@PostMapping("/team-create")
	public String teamCreate(@RequestParam("teamName") String teamName, 
							 @RequestParam("teamImage") MultipartFile teamImage, 
							 Model model) {
		TeamDto teamDto = new TeamDto(teamName, teamImage);
		service.insertTeam(teamDto);
		
		model.addAttribute("teamList", service.findAllTeam());
		model.addAttribute("action", "team");
		return "admin-edit";
	}

}
