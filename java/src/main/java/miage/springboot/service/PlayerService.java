package miage.springboot.service;

import java.util.List;

import miage.springboot.model.Food;
import miage.springboot.model.Player;

public interface PlayerService {
	Player findById(Integer id);
	List<Player> findAllPlayers();
	Player findByName(String name);
	void savePlayer(Player e);
	void updatePlayer(Player e);
	void deletePlayerById(long id);
	
	List<Player> moneyMatch(String p1, String p2, Float bet, String winner) throws Exception;
	
	Player buyFood(Player p, Food f);
}
