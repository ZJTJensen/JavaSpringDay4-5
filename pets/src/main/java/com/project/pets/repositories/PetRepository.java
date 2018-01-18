package com.project.pets.repositories;

import com.project.pets.models.Pet;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface PetRepository extends CrudRepository<Pet,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
