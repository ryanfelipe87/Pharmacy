package com.project.pharmacy.services;

import com.project.pharmacy.dtos.ClientDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {

    ClientDTO createClient(ClientDTO clientDto);

    List<ClientDTO> listAllClients();

    ClientDTO findClientById(Long id);

    ClientDTO updateClient(Long id, ClientDTO clientDTO);

    void deleteClient(Long id);
}
