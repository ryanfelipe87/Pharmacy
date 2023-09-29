package com.project.pharmacy.services.impl;

import com.project.pharmacy.dtos.ClientDTO;
import com.project.pharmacy.models.Client;
import com.project.pharmacy.repositories.ClientRepository;
import com.project.pharmacy.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public ClientDTO createClient(ClientDTO clientDto) {
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setCpf(clientDto.getCpf());
        client.setCellPhone(clientDto.getCellPhone());
        client.setBirthDate(clientDto.getBirthDate());
        client.setZipCode(clientDto.getZipCode());
        client.setAddress(clientDto.getAddress());

        client = clientRepository.save(client);

        return convertoToDTO(client);
    }

    @Override
    public List<ClientDTO> listAll() {
        List<Client> client = clientRepository.findAll();
        return client.stream()
                .map(this :: convertoToDTO)
                .collect(Collectors.toList());
    }

    public ClientDTO findById(Long id){
        Client client = clientRepository.findById(id).orElse(null);
        if(client != null){
            return convertoToDTO(client);
        }
        return null;
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            client.setName(clientDTO.getName());
            client.setCpf(clientDTO.getCpf());
            client.setCellPhone(clientDTO.getCellPhone());
            client.setBirthDate(clientDTO.getBirthDate());
            client.setZipCode(clientDTO.getZipCode());
            client.setAddress(client.getAddress());

            client = clientRepository.save(client);

            return convertoToDTO(client);
        }
        return null;
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }


    private ClientDTO convertoToDTO(Client client){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName(client.getName());
        clientDTO.setCpf(client.getCpf());
        clientDTO.setCellPhone(client.getCellPhone());
        clientDTO.setBirthDate(client.getBirthDate());
        clientDTO.setZipCode(client.getZipCode());
        clientDTO.setAddress(client.getAddress());
        return clientDTO;
    }

    private Client convertToEntity(ClientDTO clientDTO){
        Client client = new Client();
        clientDTO.setName(client.getName());
        clientDTO.setCpf(client.getCpf());
        clientDTO.setCellPhone(client.getCellPhone());
        clientDTO.setBirthDate(client.getBirthDate());
        clientDTO.setZipCode(client.getZipCode());
        clientDTO.setAddress(client.getAddress());
        return client;
    }
}
