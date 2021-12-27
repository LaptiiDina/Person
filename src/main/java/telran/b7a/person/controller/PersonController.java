package telran.b7a.person.controller;

import java.time.LocalDate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import telran.b7a.person.dao.PersonRepository;
import telran.b7a.person.dto.AddressDto;
import telran.b7a.person.dto.PersonDto;
import telran.b7a.person.dto.exception.PersonNotFoundException;
import telran.b7a.person.model.Address;
import telran.b7a.person.model.Person;
import telran.b7a.person.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping
	public boolean addPerson(@RequestBody PersonDto personDto) {
		return personService.addPerson(personDto);
	}

	@GetMapping("/{id}")
	public PersonDto findPersonById(@PathVariable Integer id) {
		return personService.findPersonById(id);
	}
	
	@DeleteMapping("/{id}")
	public PersonDto removePersob(@PathVariable  Integer id) {
		return personService.removePersob(id);
				}

		@PutMapping("/id/{id}/name/{name}")
		public PersonDto updatePersonName(@PathVariable Integer id, @PathVariable String name) {
			return personService.updatePersonName(id, name);
		}

		@PutMapping("/id/{id}")
		public PersonDto updatePersonAddress(@PathVariable Integer id,@RequestBody AddressDto addressDto) {
			return personService.updatePersonAddress(id, addressDto);
		}

		@GetMapping("/name/{name}")
		public Iterable<PersonDto> findPersonsByName(@PathVariable String name) {
			
			return personService.findPersonsByName(name);
		}

		@GetMapping("/age/{minAge}/{maxAge}")
		public Iterable<PersonDto> findPersonsBetweenAges(@PathVariable Integer minAge, @PathVariable Integer maxAge) {
		
			return personService.findPersonsBetweenAges(minAge, maxAge);
		}

		@GetMapping("/city/{city}")
		public Iterable<PersonDto> findPersonsByCity(@PathVariable String city) {
			
			return personService.findPersonsByCity(city);
		}

}
