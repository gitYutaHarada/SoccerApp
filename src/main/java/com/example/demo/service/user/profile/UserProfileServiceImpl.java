package com.example.demo.service.user.profile;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.repository.user.profile.UserProfileRepository;
import com.example.demo.session.UserSession;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

	private final UserProfileRepository repository;
	
	@Override
	public String addFavoriteTeam(String teamName, UserSession userSession) {
		
		return repository.addFavoriteTeam(teamName,userSession);
	}

	@Override
	public void setUserDto(UserDto userDto, String userName) {
		
		repository.setUserDto(userDto, userName);
	}

}
