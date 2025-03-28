package com.example.demo.session;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.dto.CommentDto;

import lombok.Data;

@Data
@Component
@SessionScope
public class CommentsListSession {

	private List<CommentDto> commentList;
	
}
