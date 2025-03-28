package com.example.demo.session;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.dto.PlayerRatingAvgDto;

import lombok.Data;

@Data
@Component
@SessionScope
public class PlayerRatingAvgListSession {

	private List<PlayerRatingAvgDto> plaerRagingAvgList;
}

