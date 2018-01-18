package com.project.questions.repositories;

import com.project.questions.controllers.Answer;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface AnswerRepository extends CrudRepository<Answer,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
