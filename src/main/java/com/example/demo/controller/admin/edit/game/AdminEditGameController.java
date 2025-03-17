package com.example.demo.controller.admin.edit.game;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.GameDto;
import com.example.demo.service.admin.edit.game.AdminEditGameService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminEditGameController {

	private final AdminEditGameService service;
	
	@GetMapping("/game-edit")
	public String gameEdit(Model model) {
		model.addAttribute("action", "game");
		return "admin-edit";
	}
	
	@PostMapping("/game-create")
	public String gameCreate(@ModelAttribute GameDto gameDto, Model model) {
		
		model.addAttribute("insertGameMsg", service.insertGame(gameDto));
		model.addAttribute("action", "game");
		return "admin-edit";
	}
}
