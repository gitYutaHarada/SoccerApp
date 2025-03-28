package com.example.demo.controller.game.comments;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.game.board.GameBoardService;
import com.example.demo.service.game.comments.GameCommentsService;
import com.example.demo.service.game.rating.GameRatingService;
import com.example.demo.session.CommentsListSession;
import com.example.demo.session.GameListSession;
import com.example.demo.session.PlayerRatingAvgListSession;
import com.example.demo.session.UserSession;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class gameCommentsController {

	private final UserSession userSession;
	private final GameListSession gameListSession;
	private final CommentsListSession commentsListSession;
	private final PlayerRatingAvgListSession playerRatingAvgListSession;
	
	private final GameCommentsService commentService;
	private final GameBoardService boardService;
	private final GameRatingService ratingService;

	@PostMapping("/select-game")
	public String selectGame(@RequestParam int gameId,
							 Model model) {
		
		gameListSession.setGameList(boardService.setAllGameDto());
		commentsListSession.setCommentList(commentService.getCommentsDtoList());
		playerRatingAvgListSession.setPlaerRagingAvgList(ratingService.getGamePlayerRatingAvgDtoList());
		model.addAttribute("gameId", gameId);
	
		return "game-comments";
	}

	@PostMapping("/add-comment")
	public String addComment(@RequestParam String commentContent,
						   	 @RequestParam int gameId,
							 Model model) {
		
		commentService.addComment(userSession.getUserId(), gameId, commentContent);
		model.addAttribute("gameId", gameId);

		return "game-comments";

	}

	@PostMapping("/add-like")
	public String addLike(@RequestParam int gameId,
						  @RequestParam int commentId,
						  Model model) throws IOException {

		commentService.isAddLike(userSession.getUserId(), commentId);
		commentsListSession.setCommentList(commentService.getCommentsDtoList());
		model.addAttribute("gameId", gameId);
		
		return "game-comments";
	}
}
