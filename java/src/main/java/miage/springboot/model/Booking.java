package miage.springboot.model;

import org.springframework.format.annotation.DateTimeFormat;

public class Booking {
	private String date;
	private Player p;	
	
	public Booking() {}
	
	public Booking(String date, Player p) {
		this.date = date;
		this.p = p;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Player getP() {
		return p;
	}
	public void setP(Player p) {
		this.p = p;
	}
	
	

}
