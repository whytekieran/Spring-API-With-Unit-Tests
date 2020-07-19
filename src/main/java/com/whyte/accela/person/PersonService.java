package com.whyte.accela.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	//Create a single instance of the TopicRepository using Autowired dependency injection
	@Autowired
	private PersonRepository peopleRepository;
	
	public List<Person> getAllPeople(){
		List<Person> people = new ArrayList<>();
		peopleRepository.findAll().forEach(people::add);
		return people;
	}
	
	public int getTotalPeople(){
		List<Person> people = new ArrayList<>();
		peopleRepository.findAll().forEach(people::add);
		return people.size();
	}
	
	public Optional<Person> getPerson(int id) {
		return peopleRepository.findById(id);
	}
	
	public void addPerson(Person person) {
		peopleRepository.save(person);
	}
	
	public void updatePerson(int id, Person person) {
		peopleRepository.save(person);
	}
	
	public void deletePerson(int id) {
		peopleRepository.deleteById(id);
	}
}
