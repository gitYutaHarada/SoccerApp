package com.example.demo.controller.game.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.game.board.GameBoardService;
import com.example.demo.session.GameListSession;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class GameBoardController {
	
	private final GameListSession gameListSession;
	private final GameBoardService service;

	@GetMapping("/game-board")
	public String gemeBoad(Model model) {
		
		model.addAttribute("selectTeamMsg", "どのチームのコメントを見ますか?teamを選択してください。");
		return "game-board";
	}
	
	@PostMapping("/select-team-board")
	public String selectTemaBoad(@RequestParam String teamName, 
								 Model model) {
		
		gameListSession.setGameList(service.setAllGameDto());
		
		model.addAttribute("selectTeam", teamName);
		model.addAttribute("action", "gameBoard");
		
		return "game-board";
	}
	
}
