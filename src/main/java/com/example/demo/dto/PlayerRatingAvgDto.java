package com.example.demo.dto;

import lombok.Data;

@Data
public class PlayerRatingAvgDto {

	private int gameId;
	private String playerName;
	private double ratingAvg;
	
}
