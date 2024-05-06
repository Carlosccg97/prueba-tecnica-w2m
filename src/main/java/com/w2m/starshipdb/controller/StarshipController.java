package com.w2m.starshipdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.w2m.starshipdb.model.Starship;

@RestController
@RequestMapping("/api/starship")
public class StarshipController {

	@Autowired
	StarshipService starshipService;
	
	@GetMapping({"/getAllStarships"})
	public ResponseEntity<List<Starship>> getAllStarships(){
		return new ResponseEntity<>(starshipService.getAllStarships(),HttpStatus.OK);
		
	}
	
	@GetMapping({"/getStarshipById/{id}"})
	public ResponseEntity<Starship> getStarshipById(@PathVariable Long id){
		
		return new ResponseEntity<Starship>(starshipService.getStarshipById(id),HttpStatus.OK);
		
	}
	
	@GetMapping({"/getStarshipsByName/{name}"})
	public ResponseEntity<List<Starship>> getStarshipsByName(@PathVariable String name){
		
		return new ResponseEntity<List<Starship>>(starshipService.getStarshipsByName(name),HttpStatus.OK);
		
	}
	
	@PostMapping({"/insertStarship"})
	public ResponseEntity<Starship> insertStarship(@RequestBody Starship ship) throws Exception{
		
		return new ResponseEntity<Starship>(starshipService.insertStarship(ship),HttpStatus.OK);
	}
	
	@PostMapping({"/updateStarship"})
	public ResponseEntity<Starship> updateStarship(@RequestBody Starship ship){
		starshipService.updateStarship(ship.getId(), ship.getName(), ship.getSaga());
		
		return new ResponseEntity<Starship>(starshipService.getStarshipById(ship.getId()),HttpStatus.OK);
	}
	
	@DeleteMapping({"/deleteStarship/{id}"})
	public ResponseEntity<Starship> deleteStarship(@PathVariable Long id){
		starshipService.deleteStarshipById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	@GetMapping({"/loadStarships"})
	public ResponseEntity<Starship> loadStarships(){
		starshipService.loadStarships();
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
