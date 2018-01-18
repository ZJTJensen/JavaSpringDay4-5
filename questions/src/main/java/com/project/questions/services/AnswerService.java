package com.project.questions.services;

import com.project.questions.controllers.Answer;
import com.project.questions.repositories.AnswerRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
	// Member variables / service initializations go here
	private AnswerRepository answerRepository;
		
	public AnswerService(AnswerRepository answerRepository){
		this.answerRepository = answerRepository;
	}

	public void create(Answer answer){
		answerRepository.save(answer);
	}

	public ArrayList<Answer> all(){
		return (ArrayList<Answer>)answerRepository.findAll();
	}
	
	public Answer findById(long id){
		return answerRepository.findOne(id);
	}

	public void destroy(long id){
		answerRepository.delete(id);
	}
	
	// Crud methods to act on services go here.
}
