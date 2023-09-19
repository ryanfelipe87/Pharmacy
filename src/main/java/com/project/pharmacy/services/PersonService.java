package com.project.pharmacy.services;

import com.project.pharmacy.dtos.PersonDto;
import com.project.pharmacy.models.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {

    Person createUser(PersonDto personDto);

    List<PersonDto> listAll();
}
