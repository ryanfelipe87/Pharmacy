package com.project.pharmacy.controllers;

import com.project.pharmacy.dtos.PersonDTO;
import com.project.pharmacy.exceptions.person.PersonGetByIdException;
import com.project.pharmacy.exceptions.person.PersonUpdateByIdException;
import com.project.pharmacy.services.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/person")
public class PersonController {

    @Autowired
    private PersonServiceImpl personService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody PersonDTO personDto) {
        personService.createUser(personDto);
        return new ResponseEntity<Void>(HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public List<PersonDTO> listAll() {
        return personService.listAllPerson();
    }

    @GetMapping("/{id}")
    public String filterById(@PathVariable Long id) {
        try {
            PersonDTO personDTO = personService.findPersonById(id);
            return personDTO.toString();
        } catch (PersonGetByIdException exception) {
            return exception.getMessage();
        }
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        try {
            PersonDTO personDTO1 = personService.updatePerson(id, personDTO);
            return personDTO1.toString();
        } catch (PersonUpdateByIdException exception) {
            return exception.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }
}
