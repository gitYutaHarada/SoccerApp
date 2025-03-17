package com.example.demo.controller.user.login;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.UserDto;
import com.example.demo.service.admin.edit.team.AdminEditTeamService;
import com.example.demo.service.user.login.LoginService;
import com.example.demo.service.user.profile.UserProfileService;
import com.example.demo.service.user.utils.UserUtilsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
	
	private final LoginService loginService;
	private final AdminEditTeamService teamService;
	private final UserProfileService profileService;
	private final UserUtilsService userUtilsService;
	
	@PostMapping("/login")
	public String login(@RequestParam String userName,
						@RequestParam String password,
						HttpSession session,
						Model model) {
		
		if(loginService.isLogin(userName, password)) {
			UserDto userDto = new UserDto();
			profileService.setUserDto(userDto, userName);
			session.setAttribute("userDto", userDto);
			session.setAttribute("teamList", teamService.findAllTeam());
			model.addAttribute("msg", "ログイン成功です");
			return "my-page";
		}
		
		String msg = "ログインに失敗しました。";
		model.addAttribute("msg", msg);
		
		return "index";
	}
	
	@PostMapping("/select-favorite")
	public String selectFavorite(@RequestParam String teamName, HttpSession session, Model model) {
		
		String favoriteMsg = 
				profileService.addFavoriteTeam(teamName, (UserDto)session.getAttribute("userDto"));
		((UserDto)session.getAttribute("userDto")).setFavoriteTeamName(teamName);
		model.addAttribute("favoriteMsg", favoriteMsg);
		return "my-page";
	}
	
}
