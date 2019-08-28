package de.devk.dojo.rockpaperscissors.server.controller;

import de.devk.dojo.rockpaperscissors.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private ClientService gameService;

    @PostMapping("/registernewclient")
    ResponseEntity<Client> registerANewClient(@RequestBody Client client) {
        return new ResponseEntity<Client>(gameService.saveClient(client), HttpStatus.CREATED);
    }

}
