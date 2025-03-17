package com.example.demo.controller.game;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.GameEntity;
import com.example.demo.service.game.GameBoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class GameBoardController {
	
	private final GameBoardService service;

	@GetMapping("/game-board")
	public String gemeBoad(Model model) {
		model.addAttribute("selectTeamMsg", "teamを選択してください。");
		return "game-boaed";
	}
	
	@PostMapping("/select-team-board")
	public String selectTemaBoad(@RequestParam String teamName, 
								 HttpSession session) {
		
		List<GameEntity> gameEntityList = service.setGameEntity(teamName);
		
		return "game-board";
	}
}
