package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class GameDto {

	private int gameId;
	private String homeTeamName;
	private String awayTeamName;
	private LocalDateTime gameTime;
	private int homeScore;
	private int awayScore;
	
}
