package com.example.demo.service.user.profile;

import com.example.demo.dto.UserDto;

public interface UserProfileService {
	
	String addFavoriteTeam(String teamName, UserDto userDto);
	
	void setUserDto(UserDto userDto, String userName);
}
