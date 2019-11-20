package com.georgeborodin.web_app.controller;

import com.georgeborodin.web_app.domain.Client;
import com.georgeborodin.web_app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/clients")
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("")
    public ResponseEntity<?> createClient(@Valid @RequestBody Client client, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for(FieldError error: result.getFieldErrors()) {
                errorMap.put(error.getField(),error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        Client newClient = clientService.saveOrUpdate(client);
        return new ResponseEntity<Client>(newClient, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Client> getAllClients() {
        return clientService.findAll();
    }

    @GetMapping("/{client_id}")
    public ResponseEntity<?> getClientById(@PathVariable Integer client_id) {
        Client client = clientService.findById(client_id);
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }

    @DeleteMapping("/{client_id}")
    public ResponseEntity<?> deleteClient(@PathVariable Integer client_id) {
        clientService.delete(client_id);
        return new ResponseEntity<String>("Client deleted", HttpStatus.OK);
    }

}
