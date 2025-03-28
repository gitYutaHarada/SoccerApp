package com.example.demo.service.user.profile;

import com.example.demo.dto.UserDto;
import com.example.demo.session.UserSession;

public interface UserProfileService {
	
	String addFavoriteTeam(String teamName, UserSession userSession);
	
	void setUserDto(UserDto userDto, String userName);
}
