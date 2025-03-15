package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserDto;
import com.example.demo.service.AdminLoginService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminLoginController {
	
	private final AdminLoginService service;
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@PostMapping("/admin")
	public String adminLogin(@ModelAttribute UserDto userDto) {
		if(service.isAdmin(userDto)) {
			return "admin-edit";
		}
		return "admin";
	}
}
