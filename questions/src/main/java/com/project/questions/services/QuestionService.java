package com.project.questions.services;

import com.project.questions.models.Question;
import com.project.questions.repositories.QuestionRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
	// Member variables / service initializations go here
		
	private QuestionRepository questionRepository;
		
	public QuestionService(QuestionRepository questionRepository){
		this.questionRepository = questionRepository;
	}

	public void create(Question question){
		questionRepository.save(question);
	}

	public ArrayList<Question> all(){
		return (ArrayList<Question>)questionRepository.findAll();
	}
	
	public Question findById(long id){
		return questionRepository.findOne(id);
	}

	public void destroy(long id){
		questionRepository.delete(id);
	}
	
	// Crud methods to act on services go here.
}
