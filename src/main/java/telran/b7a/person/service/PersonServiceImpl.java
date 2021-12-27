package telran.b7a.person.service;

import java.time.LocalDate;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import telran.b7a.person.dao.PersonRepository;
import telran.b7a.person.dto.AddressDto;
import telran.b7a.person.dto.PersonDto;
import telran.b7a.person.dto.exception.PersonNotFoundException;
import telran.b7a.person.model.Address;
import telran.b7a.person.model.Person;
@Service
public class PersonServiceImpl implements PersonService {
PersonRepository personRepository;
ModelMapper modelApper;
@Autowired
	public PersonServiceImpl(PersonRepository personRepository, ModelMapper modelApper) {
	this.personRepository = personRepository;
	this.modelApper = modelApper;
}

	@Override
	@Transactional
	public boolean addPerson(PersonDto personDto) {
		if(personRepository.existsById(personDto.getId())) {
			return false;
		}
		
		personRepository.save(modelApper.map(personDto,Person.class));
		return true;
	}

	@Override
	public PersonDto findPersonById(Integer id) {
		Person person = personRepository.findById(id).orElseThrow(()->new PersonNotFoundException());
		return modelApper.map(person, PersonDto.class);
	}

	@Override
	public PersonDto removePersob(Integer id) {
	PersonDto result =	findPersonById(id);
		 personRepository.deleteById(id);
		return result;
	}

	@Override
	public PersonDto updatePersonName(Integer id, String name) {
		Person person = personRepository.findById(id).orElseThrow(()->new PersonNotFoundException());
		person.setName(name);
		personRepository.save(person);
		return modelApper.map(person, PersonDto.class);
	}

	@Override
	public PersonDto updatePersonAddress(Integer id, AddressDto addressDto) {
		Person person = personRepository.findById(id).orElseThrow(()->new PersonNotFoundException());
		Address address = modelApper.map(addressDto,Address.class);
		person.setAddress(address);
		personRepository.save(person);
		return modelApper.map(person, PersonDto.class);
	}

	@Override
	@Transactional
	public Iterable<PersonDto> findPersonsByName(String name) {
		
		return personRepository.findByName(name)
				.map(p->modelApper.map(p,PersonDto.class))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public Iterable<PersonDto> findPersonsBetweenAges(Integer minAge, Integer maxAge) {
	
		LocalDate from = LocalDate.now().minusYears(maxAge);
				LocalDate to = LocalDate.now().minusYears(minAge);
		return personRepository.findByBirthDateBetween(from, to)
				.map(p->modelApper.map(p,PersonDto.class))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public Iterable<PersonDto> findPersonsByCity(String city) {
		
		return personRepository.findByAddressCity(city)
				.map(p->modelApper.map(p,PersonDto.class))
				.collect(Collectors.toList());
	}

}
