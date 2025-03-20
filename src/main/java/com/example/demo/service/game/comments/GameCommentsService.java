package com.example.demo.service.game.comments;

import java.io.IOException;
import java.util.List;

import com.example.demo.dto.CommentDto;

public interface GameCommentsService {

	List<CommentDto> getCommentsDtoList();
	
	void addComment(int userId, int gameId, String commentContent);
	
	boolean isAddLike(int userId, int commentId) throws IOException;
}
