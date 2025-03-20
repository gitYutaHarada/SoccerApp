package com.example.demo.repository.game.comments;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.CommentDto;
import com.example.demo.repository.user.utils.UserUtilsRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class GameCommentsRepositoryImpl implements GameCommentsRepository {

	private final JdbcTemplate jdbcTemplate;
	private final UserUtilsRepository userUtilsRepository;

	@Override
	public List<CommentDto> getCommentsDtoList() {
		
		String getCommentsEntityListSql = "SELECT * FROM comments";
		
		List<Map<String, Object>> CommentsEntityList = jdbcTemplate.queryForList(getCommentsEntityListSql);
		List<CommentDto> result = new ArrayList<>();
		
		for(Map<String, Object> comments : CommentsEntityList) {
			CommentDto dto = new CommentDto();
			dto.setCommentId((int)comments.get("comment_id"));
			dto.setUserName(userUtilsRepository.findUserNameByUserId((int)comments.get("user_id")));
			dto.setCommentContent((String)comments.get("comment_content"));
			dto.setGameId((int)comments.get("game_id"));
			dto.setLikes((int)comments.get("likes"));
			dto.setCreatedAt((Timestamp)comments.get("created_at"));
			result.add(dto);
		}
		
		return result;
	}

	@Override
	public void addComment(int userId, int gameId, String commentContent) {
		
		String addCommentSql = "INSERT INTO comments "
							 + "(user_id, game_id, comment_content) "
							 + "VALUES(?, ?, ?)";
		
	    try {
	        jdbcTemplate.update(addCommentSql, userId, gameId, commentContent);
	        System.out.println("コメント追加成功！！");
	    } catch (DataAccessException e) {
	        System.err.println("コメント追加に失敗しました: " + e.getMessage());
	    }
		
	}

	@Override
	public boolean isAddLike(int userId, int commentId) throws IOException {
		
		String isAddLikeSql = "SELECT COUNT(*) FROM likes WHERE user_id = ? AND comment_id = ?";
		String addLikeUniqueSql = "INSERT INTO likes (user_id, comment_id) VALUES(?, ?)";
		int count = jdbcTemplate.queryForObject(isAddLikeSql, Integer.class, userId, commentId);
		
		if(count == 0) {
			jdbcTemplate.update(addLikeUniqueSql, userId, commentId);

			addLike(commentId);
			return true;
		}else {
			deleteLike(userId, commentId);
			return false;
		}
		
	}

	@Override
	public void addLike(int commentId) throws IOException {
		String addLikeSql = "UPDATE comments SET likes = likes + 1 WHERE comment_id = ?";
		
		jdbcTemplate.update(addLikeSql, commentId);
	}

	@Override
	public void deleteLike(int userId, int commentId) throws IOException {
		String deleteLikeSql = "UPDATE comments SET likes = likes - 1 WHERE comment_id = ?";
		String deleteLikesSql = "DELETE FROM likes WHERE user_id = ? AND comment_id = ?";
		
		jdbcTemplate.update(deleteLikeSql, commentId);
		jdbcTemplate.update(deleteLikesSql, userId, commentId);
		
	}
	
	
}
