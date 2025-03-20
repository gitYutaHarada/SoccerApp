package com.example.demo.entity;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CommentEntity {
	
	private int commentsId;
	private int userId;
	private String commentContent;
	private int gameId;
	private int likes;
	private Timestamp createAt;
	
}
