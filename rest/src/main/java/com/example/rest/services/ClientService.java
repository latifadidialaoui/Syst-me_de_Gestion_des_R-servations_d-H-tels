package com.example.rest.services;



import com.example.rest.entities.Client;
import com.example.rest.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Client updateClient(Long id, Client clientDetails) {
        return clientRepository.findById(id)
                .map(client -> {
                    client.setNom(clientDetails.getNom());
                    client.setPrenom(clientDetails.getPrenom());
                    client.setEmail(clientDetails.getEmail());
                    client.setTelephone(clientDetails.getTelephone());
                    return clientRepository.save(client);
                }).orElseThrow(() -> new ResourceNotFoundException("Client non trouvé"));
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }


}
