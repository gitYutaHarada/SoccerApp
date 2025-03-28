package com.example.demo.session;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.dto.GameDto;

import lombok.Data;

@Component
@Data
@SessionScope
public class GameListSession {

	private List<GameDto> gameList;
	
}
