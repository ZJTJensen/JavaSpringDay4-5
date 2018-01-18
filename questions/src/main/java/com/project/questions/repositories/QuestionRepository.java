package com.project.questions.repositories;

import com.project.questions.models.Question;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface QuestionRepository extends CrudRepository<Question,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
