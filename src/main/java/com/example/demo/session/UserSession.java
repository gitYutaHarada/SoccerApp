package com.example.demo.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.dto.UserDto;

import lombok.Data;

@Data
@Component
@SessionScope
public class UserSession {
	
	private String userName;
	private int userId;
	private String favoriteTeamName;
	
	public void setFromDto(UserDto userDto) {
		this.userName = userDto.getUserName();
		this.userId = userDto.getUserId();
		this.favoriteTeamName = userDto.getFavoriteTeamName();
		
	}
}
