package com.example.demo.controller.game.rating;

import org.springframework.stereotype.Controller;

import com.example.demo.service.game.rating.GameRatingService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RatingController {

	private final GameRatingService service;
	
	
}
