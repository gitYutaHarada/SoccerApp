package com.example.demo.controller.user.login;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.UserDto;
import com.example.demo.service.user.login.LoginService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
	
	private final LoginService service;
	
	@PostMapping("/login")
	public String login(@RequestParam String userName,
						@RequestParam String password,
						HttpSession session,
						Model model) {
		
		if(service.isLogin(userName, password)) {
			UserDto userDto = new UserDto();
			userDto.setUserName(userName);
			session.setAttribute("userDto", userDto);
			
			model.addAttribute("msg", "ログイン成功です");
			return "my-page";
		}
		
		String msg = "ログインに失敗しました。";
		model.addAttribute("msg", msg);
		
		return "index";
	}
	
}
