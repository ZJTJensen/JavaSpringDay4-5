package com.project.relationships.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.relationships.models.License;
import com.project.relationships.models.Person;
import com.project.relationships.services.PersonService;

@Controller
@RequestMapping("/") // Wildcard all routes.
public class Persons{
	private PersonService personService;
    public Persons(PersonService personService){
         this.personService = personService;
		System.out.println("hello");
	}

	@RequestMapping("")
	public String persons(@ModelAttribute("person") Person person) {
		return "index";
	}

	@PostMapping("/licenses/new")
    public String newLicense(@ModelAttribute("license") License license, BindingResult result, Model model) {
			personService.addLicense(license);
            return "redirect:/person/{person_id}";
	}

	@PostMapping("/persons/new")
    public String newPerson(Model model, @ModelAttribute("person") Person person, BindingResult result) {
			person.setLicense(new License());
			// Add the person
			personService.addPerson(person);
            return "redirect:/licenses";
	}

	@RequestMapping("/person/{index}")
    public String findPersonByIndex(Model model, @PathVariable("index") Long index) {
        Person person = personService.findPersonByIndex(index);
        model.addAttribute("person", person);
        return "person";
	}

	
	@RequestMapping("/licenses")
	public String licenses(Model model, @ModelAttribute("license") License license) {
		return "license";
	}
		
}
