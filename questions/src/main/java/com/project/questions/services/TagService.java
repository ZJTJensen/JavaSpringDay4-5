package com.project.questions.services;

import com.project.questions.models.Tag;
import com.project.questions.repositories.TagRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TagService {
	// Member variables / service initializations go here
		
	private TagRepository tagRepository;
		
	public TagService(TagRepository tagRepository){
		this.tagRepository = tagRepository;
	}

	public void create(Tag tag){
		tagRepository.save(tag);
	}

	public ArrayList<Tag> all(){
		return (ArrayList<Tag>)tagRepository.findAll();
	}
	
	public Tag findById(long id){
		return tagRepository.findOne(id);
	}

	public void destroy(long id){
		tagRepository.delete(id);
	}
	
	// Crud methods to act on services go here.
}
