package com.project.pharmacy.controllers;

import com.project.pharmacy.dtos.PersonDTO;
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
    public ResponseEntity<Void> create(@RequestBody PersonDTO personDto){
        personService.createUser(personDto);
        return new ResponseEntity<Void>(HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAllPerson();
    }

    @GetMapping("/{id}")
    public PersonDTO filterById(@PathVariable Long id){
        return personService.findPersonById(id);
    }

    @PutMapping("/{id}")
    public PersonDTO update(@PathVariable Long id, @RequestBody PersonDTO personDTO){
        return personService.updatePerson(id, personDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
    }
}
