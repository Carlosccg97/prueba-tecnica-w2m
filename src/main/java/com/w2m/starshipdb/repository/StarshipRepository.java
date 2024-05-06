package com.w2m.starshipdb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.w2m.starshipdb.model.Starship;

@Repository
public interface StarshipRepository extends CrudRepository<Starship, Long>{

}
