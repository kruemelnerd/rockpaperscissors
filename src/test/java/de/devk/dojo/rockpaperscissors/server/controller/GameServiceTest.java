package de.devk.dojo.rockpaperscissors.server.controller;

import de.devk.dojo.rockpaperscissors.model.Client;
import de.devk.dojo.rockpaperscissors.model.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class GameServiceTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ClientRepository clientRepository;

    @AfterEach
    void tearDown(){
        playerRepository.deleteAll();
    }

    @Test
    void getAllPlayers() {
        Player expectedPlayer = new Player("Philipp");
        playerRepository.save(expectedPlayer);
        GameService gameService = new GameService(playerRepository, null);

        List<Player> allPlayers = gameService.findAllPlayers();
        Player lastPlayer = allPlayers.get(0);

        assertThat(lastPlayer.getName(), is(expectedPlayer.getName()));
    }


    @Test
    void saveAPlayer() {
        GameService service = new GameService(playerRepository, null);
        Player player = new Player("Philipp Test");

        service.savePlayer(player);

        assertThat(playerRepository.count(), is(1L));
    }

    @Test
    void saveAClient(){
        GameService service = new GameService(null, clientRepository);
        Client client = new Client("Client Name", 123L);
        service.saveClient(client);
        assertThat(clientRepository.count(), is(1L));
    }
}
