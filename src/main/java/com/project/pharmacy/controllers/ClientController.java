package com.project.pharmacy.controllers;

import com.project.pharmacy.dtos.ClientDTO;
import com.project.pharmacy.exceptions.client.ClientGetByIdException;
import com.project.pharmacy.exceptions.client.ClientUpdateByIdException;
import com.project.pharmacy.services.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/client")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping
    public ResponseEntity<Void> saveClient(@RequestBody ClientDTO clientDTO) {
        clientService.createClient(clientDTO);
        return new ResponseEntity<Void>(HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public List<ClientDTO> listAll() {
        return clientService.listAllClients();
    }

    @GetMapping("/{id}")
    public String findByIdClient(@PathVariable Long id) {
        try {
            ClientDTO clientDTO = clientService.findClientById(id);
            return clientDTO.toString();
        } catch (ClientGetByIdException exception) {
            return exception.getMessage();
        }
    }

    @PutMapping("/{id}")
    public String updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        try {
            ClientDTO clientDTO1 = clientService.updateClient(id, clientDTO);
            return clientDTO1.toString();
        } catch (ClientUpdateByIdException exception) {
            return exception.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
