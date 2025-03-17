package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class GameEntity {

	private int gameId;
	private int homeTeamId;
	private int awayTeamId;
	private LocalDateTime gameTime;
	private int homeScore;
	private int awayScore;

}
