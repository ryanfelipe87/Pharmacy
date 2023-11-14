package com.project.pharmacy.controllers;

import com.project.pharmacy.dtos.PersonDTO;
import com.project.pharmacy.exceptions.person.PersonGetByIdException;
import com.project.pharmacy.exceptions.person.PersonUpdateByIdException;
import com.project.pharmacy.services.impl.PersonServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/person")
@Tag(name = "Person")
public class PersonController {

    @Autowired
    private PersonServiceImpl personService;

    @PostMapping
    @Operation(
            summary = "Controller for person",
            description = "Endpoint for create a new person")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public ResponseEntity<Void> create(@RequestBody PersonDTO personDto) {
        personService.createUser(personDto);
        return new ResponseEntity<Void>(HttpStatusCode.valueOf(200));
    }

    @GetMapping
    @Operation(
            summary = "Controller for person",
            description = "Endpoint for search all persons")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public List<PersonDTO> listAll() {
        return personService.listAllPerson();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Controller for person",
            description = "Endpoint for search person for id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public String filterById(@PathVariable Long id) {
        try {
            PersonDTO personDTO = personService.findPersonById(id);
            return personDTO.toString();
        } catch (PersonGetByIdException exception) {
            return exception.getMessage();
        }
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Controller for person",
            description = "Endpoint for update person for id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public String update(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        try {
            PersonDTO personDTO1 = personService.updatePerson(id, personDTO);
            return personDTO1.toString();
        } catch (PersonUpdateByIdException exception) {
            return exception.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Controller for person",
            description = "Endpoint for delete a person for id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }
}
