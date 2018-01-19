package com.project.questions.services;
import com.project.questions.models.Question;
import com.project.questions.models.Answer;
import com.project.questions.models.Tag;
import com.project.questions.repositories.QuestionRepository;
import com.project.questions.repositories.AnswerRepository;
import com.project.questions.repositories.TagRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

	private QuestionRepository _qr;
	private AnswerRepository _ar;
	private TagRepository _tr;

	
	
	public QuestionService(QuestionRepository _qr, AnswerRepository _ar, TagRepository _tr) {
		super();
		this._qr = _qr;
		this._ar = _ar;
		this._tr = _tr;
	}

	public List<Question> getAllQuestions() {
		return (List<Question>) _qr.findAll();
	}
	public List<Tag> getAllTags() {
		return (List<Tag>) _tr.findAll();
	}

	public Tag getTagById(Long id) {
		return _tr.findOne(id);
	}


	public Question getQuestionById(Long id) {
		return _qr.findOne(id);
	}
	
	public void createQuestion(Question question) {
		_qr.save(question);
	}
	
	public Tag createTag(String subject) {
		List<Tag> allTags = (List<Tag>) _tr.findAll();
		for ( Tag targetTag : allTags) {
			String targetSubject = targetTag.getSubject();
			if (subject.equals(targetSubject)) {
				return targetTag;
			}
		}
		Tag tag = new Tag(subject);
		_tr.save(tag);
		return tag;
	}

	
	public void createAnswer(Answer answer) {
		_ar.save(answer);
	}
	
	public void theNuclearOption() {
		_qr.deleteAll();
		_ar.deleteAll();
		_tr.deleteAll();
	}
	public void updateQuestion(Question question){
		System.out.println("Test3");
		_qr.save(question);
	}
	public void updateTag(Tag tag){
		System.out.println("Test3");
		_tr.save(tag);
	}
}