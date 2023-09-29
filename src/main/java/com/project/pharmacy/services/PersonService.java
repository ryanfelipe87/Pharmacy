package com.project.pharmacy.services;

import com.project.pharmacy.dtos.PersonDTO;
import com.project.pharmacy.models.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {

    Person createUser(PersonDTO personDto);

    List<PersonDTO> listAllPerson();

    PersonDTO updatePerson(Long id, PersonDTO personDTO);

    void deletePerson(Long id);

}
