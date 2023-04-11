package miage.springboot.model;

public class Player {
	
	private Integer idPlayer;
	private String namePlayer;
	private Float debt;
	
	public Player() {	}
	
	public Player(Integer idPlayer, String namePlayer, Float debt) {
		this.idPlayer = idPlayer;
		this.namePlayer = namePlayer;
		this.debt = debt;
	}



	public Integer getIdPlayer() {
		return idPlayer;
	}
	public void setIdPlayer(Integer idPlayer) {
		this.idPlayer = idPlayer;
	}
	public String getNamePlayer() {
		return namePlayer;
	}
	public void setNamePlayer(String namePlayer) {
		this.namePlayer = namePlayer;
	}
	public Float getDebt() {
		return debt;
	}
	public void setDebt(Float debt) {
		this.debt = debt;
	}
	
	
	
}
