package miage.springboot.service;

import java.util.ArrayList;
import java.util.List;

import miage.springboot.model.Food;
import miage.springboot.model.Player;

public class PlayerImpl implements PlayerService{
	
	private List<Player> players;
	
	public PlayerImpl() {
		this.players = populateDummyPlayers();
	}
	
	@Override
	public List<Player> findAllPlayers(){
		return this.players;
	}
	
	private static List<Player> populateDummyPlayers() {
		List<Player> p = new ArrayList<Player>();
		Player p1 = new Player(0, "Ikrame", 10f);
		Player p2 = new Player(1, "Tala", 5f);
		Player p3 = new Player(2, "Eya", 0f);
		Player p4 = new Player(3, "Henri", 10f);
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		return p;
	}
	
	@Override
	public Player findById(Integer id) {
		for(Player e:this.players) {
			if(e.getIdPlayer() == id) {
				return e;
			}
		}
		return null;
	}

	@Override
	public Player findByName(String name) {
		for(Player e:this.players) {
			if(e.getNamePlayer().equals(name)) {
				return e;
			}
		}
		return null;
	}
	
	@Override
	public List<Player> moneyMatch(String p1, String p2, Float bet, String winner) throws Exception{
		Player pl1 = this.findByName(p1);
		Player pl2 = this.findByName(p2);
		ArrayList<Player> list = new ArrayList<Player>();
		list.add(pl1);
		list.add(pl2);
		
		if(pl1.getDebt() >= bet && pl2.getDebt() >= bet) {
			if(p1.equals(winner)) {
				pl1.setDebt(pl1.getDebt() - bet);
				pl2.setDebt(pl2.getDebt() + bet);
			}else {
				pl1.setDebt(pl1.getDebt() + bet);
				pl2.setDebt(pl2.getDebt() - bet);
			}
		}else {
			throw new Exception();
		}
			
		return list;
	}
	
	@Override
	public Player buyFood(Player p, Food food) {
		p.setDebt(p.getDebt() + food.getPrice());
		return p;
	}

	@Override
	public void savePlayer(Player e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePlayer(Player e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePlayerById(long id) {
		// TODO Auto-generated method stub
		
	}

	
}
