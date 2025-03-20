package com.example.demo.service.game.comments;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CommentDto;
import com.example.demo.repository.game.comments.GameCommentsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameCommentsServiceImpl implements GameCommentsService {
	
	private final GameCommentsRepository repository;
	@Override
	public List<CommentDto> getCommentsDtoList() {

		return repository.getCommentsDtoList();
	}
	
	@Override
	public void addComment(int userId, int gameId, String commentContent) {
		
		repository.addComment(userId, gameId, commentContent);
	}

	@Override
	public boolean isAddLike(int userId, int commentId) throws IOException {
		
		return repository.isAddLike(userId, commentId);
	}

}
