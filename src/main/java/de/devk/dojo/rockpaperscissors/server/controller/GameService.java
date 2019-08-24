package de.devk.dojo.rockpaperscissors.server.controller;

import java.util.List;

import de.devk.dojo.rockpaperscissors.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.devk.dojo.rockpaperscissors.model.Player;

@Service
public class GameService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    ClientRepository clientRepository;

    public GameService(PlayerRepository playerRepository, ClientRepository clientRepository) {
        this.playerRepository = playerRepository;
        this.clientRepository = clientRepository;
    }

    public List<Player> findAllPlayers() {
        return playerRepository.findAll();
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }
}
