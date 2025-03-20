package com.example.demo.controller.game.comments;

import java.io.IOException;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.UserDto;
import com.example.demo.service.game.comments.GameCommentsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class gameCommentsController {

	private final GameCommentsService service;
	
	@PostMapping("/select-game")
	public String selectGame(@RequestParam int gameId,
							 HttpSession session,
							 Model model) {
		
		session.setAttribute("commentsList", service.getCommentsDtoList());
		model.addAttribute("gameId", gameId);
		System.out.println(session.getAttribute("commentsList"));

		return "game-comments";
	}
	
	@PostMapping("/add-comment")
	public String addComment(@RequestParam String commentContent,
							 @RequestParam int gameId,
							 HttpSession session,
							 Model model) {
		service.addComment(((UserDto) session.getAttribute("userDto")).getUserId(),
							gameId,
							commentContent);
		session.setAttribute("commentsList", service.getCommentsDtoList());
		model.addAttribute("gameId", gameId);

		return "game-comments";
		
	}
	
	@PostMapping("/add-like")
	public String addLike(@RequestParam int gameId,
						  @RequestParam int commentId, 
						  HttpSession session, 
						  Model model) throws IOException {
		
		System.out.println(		service.isAddLike(((UserDto)session.getAttribute("userDto")).getUserId(), commentId));
		session.setAttribute("commentsList", service.getCommentsDtoList());
		model.addAttribute("gameId", gameId);
		return "game-comments";
	}
}
