package com.example.demo.controller.global;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.session.CommentsListSession;
import com.example.demo.session.GameListSession;
import com.example.demo.session.PlayerRatingAvgListSession;
import com.example.demo.session.TeamListSession;
import com.example.demo.session.UserSession;

import lombok.RequiredArgsConstructor;

@ControllerAdvice
@RequiredArgsConstructor
public class GrobalAdviceController {

	private final UserSession userSession;
	private final TeamListSession teamListSession;
	private final CommentsListSession commentsListSession;
	private final GameListSession gameListSession;
	private final PlayerRatingAvgListSession playerRatingAvgListSession;
	
	@ModelAttribute("userSession")
	public UserSession addUserSession() {
		return userSession;
	}
	
	@ModelAttribute("teamListSession")
	public TeamListSession addTeamListSession() {
		return teamListSession;
	}
	
	@ModelAttribute("commentsListSession")
	public CommentsListSession addCommentsListSession() {
		return commentsListSession;
	}
	
	@ModelAttribute("gameListSession")
	public GameListSession addGameListSession() {
		return gameListSession;
	}
	
	@ModelAttribute("playerRatingAvgListSession")
	public PlayerRatingAvgListSession addPlayerRatingAvgListSession() {
		return playerRatingAvgListSession;
	}
	
}
