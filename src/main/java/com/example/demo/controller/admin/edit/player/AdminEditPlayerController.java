package com.example.demo.controller.admin.edit.player;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.PlayerDto;
import com.example.demo.service.admin.edit.player.AdminEditPlayerService;
import com.example.demo.service.admin.edit.team.AdminEditTeamService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminEditPlayerController {

	private final AdminEditTeamService teamService;
	private final AdminEditPlayerService playerService;

	@GetMapping("/player-edit")
	public String playerEdit(Model model) {
		
		model.addAttribute("teamList", teamService.findAllTeam());
		model.addAttribute("msg", "teamを選択してください");
		model.addAttribute("action", "player");
		return "admin-edit";
	}
	
	@PostMapping("/select-team")
	public String selectTeam(@RequestParam String teamName, Model model) {
		
		model.addAttribute("playerList", playerService.findPlayerByTeamName(teamName));
		model.addAttribute("teamName", teamName);
		model.addAttribute("teamId", teamService.findTeamIdByName(teamName));
		model.addAttribute("action", "player");
		return "admin-edit";
	}
	
	@PostMapping("/create-player")
	public String createPlayer(@ModelAttribute PlayerDto playerDto, 
							   @RequestParam String teamName, 
							   Model model) {
		
		String msg = playerService.addPlayer(playerDto);
		model.addAttribute("addPlayerMsg", msg);
		model.addAttribute("teamName", teamName);
		model.addAttribute("teamId", teamService.findTeamIdByName(teamName));
		model.addAttribute("playerList", playerService.findPlayerByTeamName(teamName));
		model.addAttribute("action", "player");

		return "admin-edit";
	}
}
