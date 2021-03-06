package com.andrewsavich.bajter.cartridgerefillservice.service.client;

import com.andrewsavich.bajter.cartridgerefillservice.model.client.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();

    Client getClientById(Long id);

    Client getClientByName(String name);

    Client saveClient(Client client);

    void deleteClientById(Long id);
}
