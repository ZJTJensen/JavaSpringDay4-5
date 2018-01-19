package com.project.questions.controllers;

import com.project.questions.models.Question;
import com.project.questions.models.Answer;
import com.project.questions.models.Tag;
import com.project.questions.services.QuestionService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("/questions")
public class QuestionController{
	private QuestionService _qs;
	
	public QuestionController(QuestionService _qs) {
		this._qs = _qs;
	}
	
	@RequestMapping("")
	public String showDashboard(Model model) {
		List<Question> questions = _qs.getAllQuestions();
		List<Tag> tags = _qs.getAllTags();
		model.addAttribute("allTags", tags);
		model.addAttribute("questions", questions);
		return "dashboard";
	}
	
	@RequestMapping("/new")
	public String showQuestionForm(Model model) {
		model.addAttribute("question", new Question());
		return "questionForm";
	}
	
	@PostMapping("/new")
	public String createQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result, @RequestParam("tags") String tags, RedirectAttributes rA) {
		if (result.hasErrors()) {
			return "questionForm";
		}
		if (tags.length() == 0) {
			rA.addFlashAttribute("errors", "Please provide at least one tag to help people find your question more easily.");
			return "redirect:/questions/new";
		}
		String[] tagsArray = tags.toLowerCase().split("\\s*,\\s*");
		if (tagsArray.length > 3) {
			rA.addFlashAttribute("errors", "Each question can handle at most three tags.");
			return "redirect:/questions/new";
		}
		for ( String element : tagsArray ) {
			if (element.equals("")) {
				rA.addFlashAttribute("errors", "Please, no empty tags. They gum up the works on the back end something fierce.");
				return "redirect:/questions/new";
			}
		}

		_qs.createQuestion(question);
		ArrayList<Tag> allTags = new ArrayList<Tag> ();
		System.out.println("Array list" + allTags);
		for ( String element : tagsArray) {
			
			Tag newTag = _qs.createTag(element);
			System.out.println("hello i am newtag" + newTag);
			allTags.add(newTag);
		
		}

		question.setTag(allTags);
		_qs.updateQuestion(question);
		
		


		return "redirect:/questions";	
	}
	
	@RequestMapping("/{id}")
	public String showQuestion(@PathVariable("id") Long id, Model model, @ModelAttribute("answer") Answer answer, BindingResult result ) {
		
		model.addAttribute("question", _qs.getQuestionById(id));
		return "displayQuestion";
	}
	
	@PostMapping("/{id}")
	public String createAnswer(@RequestParam("text") String text, @PathVariable("id") Long id) {
		Answer newAnswer = new Answer(text);
		Question question = _qs.getQuestionById(id);
		newAnswer.setQuestion(question);
		_qs.createAnswer(newAnswer);
		return "redirect:/questions/" + id;
	}
	

}
