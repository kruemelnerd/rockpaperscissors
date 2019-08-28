package de.devk.dojo.rockpaperscissors.server.controller;

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


    @AfterEach
    void tearDown(){
        playerRepository.deleteAll();
    }

    @Test
    void getAllPlayers() {
        Player expectedPlayer = new Player("Philipp");
        playerRepository.save(expectedPlayer);
        GameService gameService = new GameService(playerRepository);

        List<Player> allPlayers = gameService.findAllPlayers();
        Player lastPlayer = allPlayers.get(0);

        assertThat(lastPlayer.getName(), is(expectedPlayer.getName()));
    }


    @Test
    void saveAPlayer() {
        GameService service = new GameService(playerRepository);
        Player player = new Player("Philipp Test");

        service.savePlayer(player);

        assertThat(playerRepository.count(), is(1L));
    }

}
