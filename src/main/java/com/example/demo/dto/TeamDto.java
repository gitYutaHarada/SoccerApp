package com.example.demo.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class TeamDto {

	private String teamName;
	private MultipartFile teamImage;
	
	public TeamDto(String teamName, MultipartFile teamImage) {
		
		this.teamName = teamName;
		this.teamImage = teamImage;
		
	}
	
}
