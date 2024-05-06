package com.w2m.starshipdb;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.w2m.starshipdb.controller.StarshipService;
import com.w2m.starshipdb.model.Starship;


@SpringBootTest
class StarshipdbApplicationTests {
	
	StarshipService starshipService;
	@BeforeAll
	public void loadStarships() {
		starshipService.loadStarships();
	}
	
	@Test
	@DisplayName("Get all Starships from database")
	public void getAllStarshipsTest() {
		List<Starship> shipsList = starshipService.getAllStarships();
		assertEquals(shipsList.size(), 3);
	}

}
