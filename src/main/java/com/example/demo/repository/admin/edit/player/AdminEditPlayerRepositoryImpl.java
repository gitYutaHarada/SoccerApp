package com.example.demo.repository.admin.edit.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.PlayerDto;
import com.example.demo.entity.PlayerEntity;
import com.example.demo.repository.admin.edit.team.AdminEditTeamRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AdminEditPlayerRepositoryImpl implements AdminEditPlayerRepository {

	private final JdbcTemplate jdbcTemplate;
	private final AdminEditTeamRepository teamRepository;

	@Override
	public List<PlayerEntity> findPlayerByTeamName(String teamName) {

		int teamId = teamRepository.findTeamIdByName(teamName);
		
		String findPlayerByTeamNameSql = "SELECT * FROM players WHERE team_id = ?";
		List<Map<String, Object>> playerList = jdbcTemplate.queryForList(findPlayerByTeamNameSql, teamId);
		List<PlayerEntity> playerEntityList = new ArrayList<>();

		if(playerList.isEmpty()) {
			System.out.println("team_idで選手を探した結果,選手はいませんでした");
			return new ArrayList<>();
		}
		for (Map<String, Object> player : playerList) {
			PlayerEntity playerEntity = new PlayerEntity();
			playerEntity.setPlayerId((int) player.get("player_id"));
			playerEntity.setTeamId((int) player.get("team_id"));
			playerEntity.setPlayerName((String) player.get("player_name"));
			playerEntity.setPlayerNum((int)player.get("player_num"));
			playerEntityList.add(playerEntity);
		}

		return playerEntityList;
	}

	@Override
	public String addPlayer(PlayerDto playerDto) {

		if(countPlayer(playerDto) != 0 ) {
			return "選択したチームの中にその名前の選手はもう存在しています";
		}
		
		addPlayerRating(playerDto);
		//選手追加
		String addPlayerSql = "INSERT INTO players (team_id, player_name, player_num) VALUES(?, ?, ?)";
		int addCount = jdbcTemplate.update(addPlayerSql, 
										   playerDto.getTeamId(),
										   playerDto.getPlayerName(), 
										   playerDto.getPlayerNum());
		if (addCount == 1) {
			return "選手登録できました。";
		}
		
		return "選手登録失敗しています。";
	}
	
	//選手追加した際に、その選手が所属しているすべての試合に選手評価を追加する。
	public void addPlayerRating(PlayerDto playerDto) {
		
		List<Integer> gamesForTeam = selectGameByTeam(playerDto.getTeamId());
		String addPlayerRatingSql = "INSERT INTO player_game_ratings_avg "
								  + "(game_id, player_id) VALUES (?, ?)";

		for(int gameId : gamesForTeam) {
			jdbcTemplate.update(addPlayerRatingSql, gameId, findPlayerId(playerDto));
		}
	}
	
	//その選手が所属しているteamがホームで参加した試合を全権取得
	public List<Integer> selectGameByTeam(int teamId){
		
		String selectGameByPlayer = "SELECT game_id FROM games WHERE home_team_id = ?";
		
		return jdbcTemplate.queryForList(selectGameByPlayer, Integer.class, teamId);
		
	}

	//teamに同じ名前の選手が何人いるかどうか確認
	@Override
	public int countPlayer(PlayerDto playerDto) {
		
		String findPlayerIdSql = "SELECT player_id FROM players WHERE team_id = ? AND player_name = ?";
		List<Integer> playerList = jdbcTemplate.queryForList(findPlayerIdSql,
				Integer.class,
				playerDto.getTeamId(),
				playerDto.getPlayerName());
		
		//選択した1teamに同じ名前の選手が何人いるかどうか確認
		return playerList.size();
	}

	@Override
	public int findPlayerId(PlayerDto playerDto) {

		String findPlayerIdSql = "SELECT player_id FROM players WHERE team_id = ? AND player_name = ?";
		List<Integer> playerList = jdbcTemplate.queryForList(findPlayerIdSql,
				Integer.class,
				playerDto.getTeamId(),
				playerDto.getPlayerName());
		
		//選択したチームの中の選択した選手名はいない
		if(playerList.isEmpty())
			return 0;
		else if(playerList.size() == 1)
			return playerList.get(0);
		//選択したチームの中の選択した選手名が複数いる
		else
			return -1;
	}
	

	@Override
	public String findPlayerNameById(int id) {
		String findPlayerNameByIdSql = "SELECT player_name FROM players WHERE player_id = ?";
		
		return jdbcTemplate.queryForObject(findPlayerNameByIdSql, String.class, id);
	}
	
	

}
