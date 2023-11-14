package com.project.pharmacy.controllers;

import com.project.pharmacy.dtos.ClientDTO;
import com.project.pharmacy.exceptions.client.ClientGetByIdException;
import com.project.pharmacy.exceptions.client.ClientUpdateByIdException;
import com.project.pharmacy.services.impl.ClientServiceImpl;
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
@RequestMapping(path = "/api/client")
@Tag(name = "Client")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping
    @Operation(
            summary = "Controller for clients of a Pharmacy",
            description = "Endpoint for insert a new client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public ResponseEntity<Void> saveClient(@RequestBody ClientDTO clientDTO) {
        clientService.createClient(clientDTO);
        return new ResponseEntity<Void>(HttpStatusCode.valueOf(200));
    }

    @GetMapping
    @Operation(
            summary = "Controller for clients of a Pharmacy",
            description = "Endpoint for search all clients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public List<ClientDTO> listAll() {
        return clientService.listAllClients();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Controller for clients of a Pharmacy",
            description = "Endpoint for search a client for id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public String findByIdClient(@PathVariable Long id) {
        try {
            ClientDTO clientDTO = clientService.findClientById(id);
            return clientDTO.toString();
        } catch (ClientGetByIdException exception) {
            return exception.getMessage();
        }
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Controller for clients of a Pharmacy",
            description = "Endpoint for update a client for id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public String updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        try {
            ClientDTO clientDTO1 = clientService.updateClient(id, clientDTO);
            return clientDTO1.toString();
        } catch (ClientUpdateByIdException exception) {
            return exception.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Controller for clients of a Pharmacy",
            description = "Endpoint for delete a client for id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
