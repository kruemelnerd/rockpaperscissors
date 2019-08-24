package de.devk.dojo.rockpaperscissors.server.controller;

import java.util.List;

import de.devk.dojo.rockpaperscissors.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.devk.dojo.rockpaperscissors.model.Player;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;
    
    @GetMapping("/players")
    ResponseEntity<List<Player>> getAllPlayer(){
        return new ResponseEntity<>(gameService.findAllPlayers(), HttpStatus.OK);
    }


    @PostMapping("/players")
    ResponseEntity<Player> saveNewPlayer(@RequestBody Player player){
        return new ResponseEntity<Player>( gameService.savePlayer(player), HttpStatus.CREATED);
    }

    @PostMapping("/registernewclient")
    ResponseEntity<Client> registerANewClient(@RequestBody Client client){
        return new ResponseEntity<Client>( gameService.saveClient(client), HttpStatus.CREATED);
    }

}
