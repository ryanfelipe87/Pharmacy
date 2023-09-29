package com.project.pharmacy.controllers;

import com.project.pharmacy.dtos.ClientDTO;
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
    public ResponseEntity<Void> saveClient(@RequestBody ClientDTO clientDTO){
        clientService.createClient(clientDTO);
        return new ResponseEntity<Void>(HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public List<ClientDTO> listAll(){
        return clientService.listAll();
    }

    @GetMapping("/{id}")
    public ClientDTO findByIdClient(@PathVariable Long id){
        return clientService.findById(id);
    }

    @PutMapping("/{id}")
    public ClientDTO updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO){
        return clientService.updateClient(id, clientDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }
}
