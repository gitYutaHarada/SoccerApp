package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserDto;
import com.example.demo.service.LoginService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
	
	private final LoginService service;
	
	@PostMapping("/login")
	public String login(@ModelAttribute UserDto userInfo, Model model) {
		
		if(service.isLogin(userInfo)) {
			model.addAttribute("msg", "ログイン成功です");
			return "my-page";
		}
		
		String msg = "ログインに失敗しました。";
		model.addAttribute("msg", msg);
		
		return "index";
	}
	
}
