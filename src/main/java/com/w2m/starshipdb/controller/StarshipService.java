package com.w2m.starshipdb.controller;

import java.util.List;

import com.w2m.starshipdb.model.Starship;

public interface StarshipService {

	List<Starship> getAllStarships();
	
	Starship getStarshipById(Long id);
	
	List<Starship> getStarshipsByName(String name);
	
	Starship insertStarship(Starship starship) throws Exception;
	
	void updateStarship(Long id, String name, String saga) throws Exception;
	
	void deleteStarshipById(Long id);
	
	void loadStarships();
}
