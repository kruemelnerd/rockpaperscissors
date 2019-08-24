package de.devk.dojo.rockpaperscissors.game.logic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import de.devk.dojo.rockpaperscissors.game.logic.NotEnoughPlayersException;
import de.devk.dojo.rockpaperscissors.game.logic.Sign;
import de.devk.dojo.rockpaperscissors.game.logic.ai.GameWithAi;
import de.devk.dojo.rockpaperscissors.game.logic.ai.RockAi;
import de.devk.dojo.rockpaperscissors.model.Player;

public class AiRockTest {
    
    @Test
    void testSimpleAi() {
        
        GameWithAi gameWithAi = new GameWithAi(new RockAi());
        Player player = new Player("TestUser1");
        gameWithAi.addPlayer(player);
        
        List<Player> allPlayers = gameWithAi.getAllPlayers();
        assertThat(allPlayers, hasSize(2));
        assertThat(allPlayers, hasItem(Matchers.<Player>hasProperty("name", is("TestUser1"))));
        assertThat(allPlayers, hasItem(Matchers.<Player>hasProperty("name", is(RockAi.class.getName()))));
    }

    @Test
    public void startFirstGame() {
        GameWithAi game = initNewGame();
        game.start();
        List<Player> allPlayers = game.getAllPlayers();
        assertThat(allPlayers.get(0).getScore(), is(0));
        assertThat(allPlayers.get(1).getScore(), is(0));
    }
    
    @Test
    public void playFirstRound() throws NotEnoughPlayersException {
        GameWithAi game = initNewGame();
        game.start();
        List<Player> allPlayers = game.getAllPlayers();
        Player player1 = allPlayers.get(0);
        player1.setHandsign(Sign.PAPER);
        
        game.nextRound();

        assertThat(allPlayers.get(0).getScore(), is(1));
        assertThat(allPlayers.get(1).getScore(), is(0));
    }

    
    @Test
    public void playTwoRounds() throws NotEnoughPlayersException {
        GameWithAi game = initNewGame();
        game.start();
        List<Player> allPlayers = game.getAllPlayers();
        Player player1 = allPlayers.get(0);
        player1.setHandsign(Sign.PAPER);
        
        game.nextRound();

        player1.setHandsign(Sign.SCISSORS);
        game.nextRound();
        
        assertThat(allPlayers.get(0).getScore(), is(1));
        assertThat(allPlayers.get(1).getScore(), is(1));
    }
    
    @Test
    public void playThreeRounds() throws NotEnoughPlayersException {
        GameWithAi game = initNewGame();
        game.start();
        List<Player> allPlayers = game.getAllPlayers();
        Player player1 = allPlayers.get(0);
        player1.setHandsign(Sign.PAPER);
        
        game.nextRound();

        player1.setHandsign(Sign.SCISSORS);
        game.nextRound();
        game.nextRound();
        
        assertThat(allPlayers.get(0).getScore(), is(1));
        assertThat(allPlayers.get(1).getScore(), is(2));
    }

    private GameWithAi initNewGame() {
        GameWithAi gameWithAi = new GameWithAi(new RockAi());
        Player player = new Player("TestUser1");
        gameWithAi.addPlayer(player);
        return gameWithAi;
    }
}
