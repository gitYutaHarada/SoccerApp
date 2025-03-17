package com.example.demo.service.user.profile;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.repository.user.profile.UserProfileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

	private final UserProfileRepository repository;
	
	@Override
	public String addFavoriteTeam(String teamName, UserDto userDto) {
		
		return repository.addFavoriteTeam(teamName,userDto);
	}

	@Override
	public void setUserDto(UserDto userDto, String userName) {
		
		repository.setUserDto(userDto, userName);
	}

}
