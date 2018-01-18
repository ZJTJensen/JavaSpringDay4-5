package com.project.relationships.services;

import com.project.relationships.models.License;
import com.project.relationships.models.Person;
import com.project.relationships.repositories.LicenseRepository;
import com.project.relationships.repositories.PersonRepository;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
	// Member variables / service initializations go here

	private LicenseRepository licenseRepository;
    public void LicenseService(LicenseRepository licenseRepository){
        this.licenseRepository = licenseRepository;
	}
	private PersonRepository personRepository;
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
	}
	

		
	public PersonService(){

	}
	public List<Person> allPersons() {
		return personRepository.findAll();
	}
	public List<License> allLicenses() {
		return licenseRepository.findAll();
	}

	public void addPerson(Person person) {
		System.out.println("Person when it gets to service: " + person.getFirstName());
		personRepository.save(person);
		System.out.println("All done!");
	}
	public void addLicense(License license) {
		licenseRepository.save(license);
	}

	public Person findPersonByIndex(Long id) {
		return personRepository.findOne(id);
	}
	// Crud methods to act on services go here.
}
