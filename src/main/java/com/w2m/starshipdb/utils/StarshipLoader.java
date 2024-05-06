package com.w2m.starshipdb.utils;

import org.springframework.boot.CommandLineRunner;

import com.w2m.starshipdb.model.Starship;
import com.w2m.starshipdb.repository.StarshipRepository;

public class StarshipLoader implements CommandLineRunner {
	
	public final StarshipRepository starshipRepository;
	
	public StarshipLoader (StarshipRepository starshipRepository) {
		this.starshipRepository = starshipRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		if (starshipRepository.count() == 0) {
			starshipRepository.save(new Starship((long) 1, "Enterprise", "Star Treck"));
			starshipRepository.save(new Starship((long) 2, "X-Wing", "Star Wars"));
			starshipRepository.save(new Starship((long) 3, "T-Wing", "Star Wars"));
			
		}
		
	}

}
