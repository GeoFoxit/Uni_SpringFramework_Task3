package com.georgeborodin.web_app.service;

import com.georgeborodin.web_app.domain.Client;
import com.georgeborodin.web_app.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client saveOrUpdateClient(Client client) {
        return clientRepository.save(client);
    }

    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Integer id) {
        return clientRepository.getById(id);
    }

    public void delete(Integer id) {
        Client client = findById(id);
        clientRepository.delete(client);
    }

}
