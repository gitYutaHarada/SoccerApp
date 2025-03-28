package com.example.demo.repository.user.profile;

import com.example.demo.dto.UserDto;
import com.example.demo.session.UserSession;

public interface UserProfileRepository {

	String addFavoriteTeam(String teamName, UserSession userSession);
	
	void setUserDto(UserDto userDto, String userName);

}
