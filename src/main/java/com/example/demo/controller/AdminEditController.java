package com.example.demo.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.TeamDto;
import com.example.demo.entity.TeamEntity;
import com.example.demo.service.AdminEditService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminEditController {
	
	private final AdminEditService service;
	
	@GetMapping("/team-edit")
	public String teamEdit(Model model) {
		
		List<TeamEntity> teamList = service.findAllTeam();
		
		System.out.println("teamName===" + teamList.get(0).getTeamName());
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
