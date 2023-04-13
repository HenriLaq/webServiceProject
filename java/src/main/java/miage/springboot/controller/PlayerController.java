package miage.springboot.controller;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

import miage.springboot.model.Player;
import miage.springboot.service.FoodImpl;
import miage.springboot.service.FoodService;
import miage.springboot.service.PlayerImpl;
import miage.springboot.service.PlayerService;

@RestController
@CrossOrigin
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
	
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public Object createBooking(@RequestParam String date, @RequestParam String name, @RequestParam String email) {
		if(this.ps.findByName(name) == null) {
			this.ps.savePlayer(name);
		}
		System.out.println(date);
		RedirectView redirectView = new RedirectView();
	    redirectView.setUrl("www.google.fr");
	    this.ps.findByName(name);
		return redirectView;
	}
	
	@RequestMapping(value = "/match", method = RequestMethod.POST)
	public Object doMoneyMatch(@RequestParam String name1, @RequestParam String name2, @RequestParam Float bet, @RequestParam String winner) {
		if((this.ps.findByName(name1) == null) || (this.ps.findByName(name2) == null) || (bet <= 0f) 
				|| ((!winner.equals(name1)) && (!winner.equals(name2))) 
				){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			try {
				RedirectView redirectView = new RedirectView();
			    redirectView.setUrl("www.google.fr");
			    this.ps.moneyMatch(name1, name2, bet, winner);
			    return redirectView;
			} catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player Not Found");
			}
		}
	}
	
	@RequestMapping(value = "/food", method = RequestMethod.POST)
	public Object buyFood(@PathVariable String namep, @PathVariable String food) {
		if(this.ps.findByName(namep) == null || this.fs.findByName(food) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			RedirectView redirectView = new RedirectView();
		    redirectView.setUrl("www.google.fr");
		    this.ps.buyFood(this.ps.findByName(namep), this.fs.findByName(food));
			return redirectView;
		}
	}

}
