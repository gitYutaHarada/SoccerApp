package com.example.demo.controller.game.comments;

import java.io.IOException;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.UserDto;
import com.example.demo.service.game.board.GameBoardService;
import com.example.demo.service.game.comments.GameCommentsService;
import com.example.demo.service.game.rating.GameRatingService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class gameCommentsController {

	private final GameCommentsService commentService;
	private final GameBoardService boardService;
	private final GameRatingService ratingService;

	@PostMapping("/select-game")
	public String selectGame(@RequestParam int gameId,
							 HttpSession session,
							 Model model) {

		
		session.setAttribute("gameDtoList", boardService.setAllGameDto());
		session.setAttribute("commentsList", commentService.getCommentsDtoList());
		
		model.addAttribute("playerRatingAvgDtoList", ratingService.getGamePlayerRatingAvg());
		System.out.println(boardService.setAllGameDto());
		System.out.println(commentService.getCommentsDtoList());
		System.out.println(ratingService.getGamePlayerRatingAvg());
		model.addAttribute("gameId", gameId);

		return "game-comments";
	}

	@PostMapping("/add-comment")
	public String addComment(@RequestParam String commentContent,
						   	 @RequestParam int gameId,
							 HttpSession session,
							 Model model) {
		commentService.addComment(((UserDto) session.getAttribute("userDto")).getUserId(),
							gameId,
							commentContent);
		session.setAttribute("gameDtoList", boardService.setAllGameDto());
		session.setAttribute("commentsList", commentService.getCommentsDtoList());
		model.addAttribute("gameId", gameId);

		return "game-comments";

	}

	@PostMapping("/add-like")
	public String addLike(@RequestParam int gameId,
						  @RequestParam int commentId,
						  HttpSession session,
						  Model model) throws IOException {

		commentService.isAddLike(((UserDto) session.getAttribute("userDto")).getUserId(), commentId);
		session.setAttribute("gameDtoList", boardService.setAllGameDto());
		session.setAttribute("commentsList", commentService.getCommentsDtoList());
		model.addAttribute("gameId", gameId);
		return "game-comments";
	}
}
