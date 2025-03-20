package com.example.demo.controller.game.board;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.GameDto;
import com.example.demo.service.game.board.GameBoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class GameBoardController {
	
	private final GameBoardService service;

	@GetMapping("/game-board")
	public String gemeBoad(Model model, HttpSession session) {
		model.addAttribute("selectTeamMsg", "どのチームのコメントを見ますか?teamを選択してください。");
		return "game-board";
	}
	
	@PostMapping("/select-team-board")
	public String selectTemaBoad(@RequestParam String teamName, 
								 HttpSession session,
								 Model model) {
		
		List<GameDto> gameDtoList = service.setAllGameDto();
		session.setAttribute("gameDtoList", gameDtoList);
		model.addAttribute("selectTeam", teamName);
		model.addAttribute("action", "gameBoard");
		
		return "game-board";
	}
	
}
