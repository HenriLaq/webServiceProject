package miage.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import miage.springboot.model.Player;
import miage.springboot.service.FoodImpl;
import miage.springboot.service.FoodService;
import miage.springboot.service.PlayerImpl;
import miage.springboot.service.PlayerService;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {
	
	private PlayerService ps;
	
	private FoodService fs;
	
	public PlayerController() {
		ps = new PlayerImpl();
		fs = new FoodImpl();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Player>> listAllEmployee() {
		if(this.ps.findAllPlayers().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(this.ps.findAllPlayers(), HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Player> findPlayerById(@PathVariable Integer id) {
		if(this.ps.findById(id) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(this.ps.findById(id), HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
	public ResponseEntity<Player> findPlayerByName(@PathVariable String name) {
		if(this.ps.findByName(name) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(this.ps.findByName(name), HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/match/{name1}/{name2}/{bet}/{winner}", method = RequestMethod.GET)
	public ResponseEntity<List<Player>> doMoneyMatch(@PathVariable String name1, @PathVariable String name2, @PathVariable Float bet, @PathVariable String winner) {
		System.out.println("0");
		if((this.ps.findByName(name1) == null) || (this.ps.findByName(name2) == null) || (bet <= 0f) 
				|| ((!winner.equals(name1)) && (!winner.equals(name2))) 
				){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			try {
				return new ResponseEntity<>(this.ps.moneyMatch(name1, name2, bet, winner), HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@RequestMapping(value = "/{namep}/food/{namef}", method = RequestMethod.GET)
	public ResponseEntity<Player> buyFood(@PathVariable String namep, @PathVariable String namef) {
		if(this.ps.findByName(namep) == null || this.fs.findByName(namef) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(this.ps.buyFood(this.ps.findByName(namep), this.fs.findByName(namef)), HttpStatus.OK);
		}
	}
}
