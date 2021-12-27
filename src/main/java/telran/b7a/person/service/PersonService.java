package telran.b7a.person.service;

import telran.b7a.person.dto.AddressDto;
import telran.b7a.person.dto.PersonDto;

public interface PersonService {
boolean addPerson(PersonDto personDto);
PersonDto findPersonById(Integer id);
PersonDto removePersob(Integer id);
PersonDto updatePersonName(Integer id, String name);
PersonDto updatePersonAddress(Integer id, AddressDto addressDto);
Iterable<PersonDto> findPersonsByName(String name);
Iterable<PersonDto> findPersonsBetweenAges(Integer minAge,Integer maxAge);
Iterable<PersonDto> findPersonsByCity(String city);
}
