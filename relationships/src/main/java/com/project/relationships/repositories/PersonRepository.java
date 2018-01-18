package com.project.relationships.repositories;

import com.project.relationships.models.Person;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface PersonRepository extends CrudRepository<Person,Long>{
	// Query methods go here.
	List<Person> findAll();
	// Example:
	// public YourModelHere findByName(String name);
}
