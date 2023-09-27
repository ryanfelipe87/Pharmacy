package com.project.pharmacy.controllers;

import com.project.pharmacy.dtos.PersonDto;
import com.project.pharmacy.models.Person;
import com.project.pharmacy.services.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/person")
public class PersonController {

    @Autowired
    private PersonServiceImpl personService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody PersonDto personDto){
        personService.createUser(personDto);
        return new ResponseEntity<Void>(HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public List<PersonDto> list(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDto filterById(@PathVariable Long id){
        return personService.findId(id);
    }
}
