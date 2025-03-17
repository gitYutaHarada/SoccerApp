package com.example.demo.controller.user.create;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.user.create.CreateUserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CreateUserController {

	private final CreateUserService service;
	
	@GetMapping("/create-user")
	public String createUser() {
		return "create-user";
	}
	
	@PostMapping("/create-user")
	public String createUser(@RequestParam String userName,
							 @RequestParam String password, 
							 Model model) {
		
		if(service.isUserNameUnique(userName) && service.isCreateUser(userName, password)){
			model.addAttribute("msg", "新規登録成功しました。");
			return "my-page";	
		}
		
		model.addAttribute("msg", "名前が使用できません。他の名前を選んで下さい");
		
		return "create-user";
	}
}
