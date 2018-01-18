package com.project.questions.controllers;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/question")
public class Question{
	//Member variables go here
	public QuestionController(CategoryService categoryService, QuestionService questionService){
		this.categoryService = categoryService;
		this.questionService = questionService;
	}

	@RequestMapping("")
	public String questions(@ModelAttribute("question") Question question){
		return "question";
	}



	

	public Question(){

	}
	
	@RequestMapping("yourRoute")
	public String yourMethod(){
		return "yourView";
	}	
}
