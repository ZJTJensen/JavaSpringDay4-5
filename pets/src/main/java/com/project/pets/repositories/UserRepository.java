package com.project.pets.repositories;

import com.project.pets.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface UserRepository extends CrudRepository<User,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
