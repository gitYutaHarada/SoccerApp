package com.example.demo.repository.user.profile;

import com.example.demo.dto.UserDto;

public interface UserProfileRepository {

	String addFavoriteTeam(String teamName, UserDto userDto);
	
	void setUserDto(UserDto userDto, String userName);

}
