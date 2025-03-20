package com.example.demo.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CommentDto {

	private int commentId;
	private String userName;
	private String commentContent;
	private int gameId;
	private int likes;
	private Timestamp createdAt;
	
}
