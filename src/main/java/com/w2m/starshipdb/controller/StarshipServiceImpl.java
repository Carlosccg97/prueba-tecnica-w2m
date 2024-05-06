package com.w2m.starshipdb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.w2m.starshipdb.model.Starship;
import com.w2m.starshipdb.repository.StarshipRepository;

@Service
public class StarshipServiceImpl implements StarshipService{

	@Autowired
	StarshipRepository starshipRepository;
	
	@Override
	public List<Starship> getAllStarships() {
		return (List<Starship>) starshipRepository.findAll();
	}

	@Override
	public Starship getStarshipById(Long id) {
		
		return starshipRepository.findById(id).get();
	}

	@Override
	public List<Starship> getStarshipsByName(String name) {
		List<Starship> matchShips = new ArrayList<Starship>();
		
		for (Starship ship : starshipRepository.findAll()) {
			if(ship.getName().contains(name)) {
				matchShips.add( ship);
			}
		}
		return matchShips;
	}

	@Override
	public Starship insertStarship(Starship starship) throws Exception {
		
		Starship shipDB = starshipRepository.findById(starship.getId()).get();
		
		if(shipDB == null) {
			return starshipRepository.save(starship);
		}else {
			throw new Exception("ERROR: ID duplicado");
		}
		
		
	}

	@Override
	public void updateStarship(Long id, String name, String saga) throws Exception {
		Starship shipDB = starshipRepository.findById(id).get();
		
		if (shipDB == null) {
			throw new Exception("ERROR: ID inexistente");
		}
		shipDB.setName(name);
		shipDB.setSaga(saga);
		starshipRepository.save(shipDB);
		
	}

	@Override
	public void deleteStarshipById(Long id) {
		starshipRepository.deleteById(id);
		
	}

	@Override
	public void loadStarships() {
		starshipRepository.save(new Starship((long) 1, "Enterprise", "Star Treck"));
		starshipRepository.save(new Starship((long) 2, "X-Wing", "Star Wars"));
		starshipRepository.save(new Starship((long) 3, "T-Wing", "Star Wars"));
		
	}

}
