package com.example.demo.repository.game.comments;

import java.io.IOException;
import java.util.List;

import com.example.demo.dto.CommentDto;

public interface GameCommentsRepository {

	List<CommentDto> getCommentsDtoList();
	
	void addComment(int userId, int gameId, String commentContent);
	
	boolean isAddLike(int userId, int commentId) throws IOException;
	
	void addLike(int commentId) throws IOException;
	
	void deleteLike(int userId, int commentId) throws IOException;
}
