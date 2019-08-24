package de.devk.dojo.rockpaperscissors.game.logic;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import de.devk.dojo.rockpaperscissors.game.logic.GameLogic;
import de.devk.dojo.rockpaperscissors.game.logic.NotEnoughPlayersException;
import de.devk.dojo.rockpaperscissors.game.logic.Sign;
import de.devk.dojo.rockpaperscissors.model.Player;

public class GameLogicTest {

    @Test
    public void initGameWithOnePlayer() {
        GameLogic game = new GameLogic();
        Player player1 = new Player("TestUser1");

        game.addPlayer(player1);

        List<Player> allPlayers = game.getAllPlayers();
        assertThat(allPlayers, hasSize(1));
        //assertThat(allPlayers.get(0), is(player1));
        assertThat(allPlayers, hasItem(Matchers.<Player>hasProperty("name", is("TestUser1"))));

    }

    @Test
    public void checkGameWithTwoPlayers() {

        GameLogic game = initGameWithTwoPlayers();
        List<Player> allPlayers = game.getAllPlayers();
        assertThat(allPlayers, hasSize(2));
        assertThat(allPlayers.get(0).getName(), is("TestUser1"));
        assertThat(allPlayers.get(1).getName(), is("TestUser2"));
    }

    @Test
    public void startFirstGame() {
        GameLogic game = initGameWithTwoPlayers();
        game.start();

        List<Player> allPlayers = game.getAllPlayers();
        assertThat(allPlayers.get(0).getScore(), is(0));
        assertThat(allPlayers.get(1).getScore(), is(0));

    }
    
    @Test
    public void tryAGameWithNotEnoughPlayers() {
        GameLogic game = new GameLogic();
        Player player1 = new Player("TestUser1");

        game.addPlayer(player1);

        game.start();
        assertThrows(NotEnoughPlayersException.class, () -> game.nextRound());
    }
    
    
    @Test
    public void paperBeatsRock() throws NotEnoughPlayersException {
        GameLogic game = initGameWithTwoPlayers();
        game.start();
        
        List<Player> allPlayers = game.getAllPlayers();
        Player player1 = allPlayers.get(0);
        Player player2 = allPlayers.get(1);
        
        player1.setHandsign(Sign.PAPER);
        player2.setHandsign(Sign.ROCK);
        
        game.nextRound();
        
        assertThat(player1.getScore(), is(1));
        assertThat(player2.getScore(), is(0));

    }
    
    @Test
    public void rockBeatsScissors() throws NotEnoughPlayersException {
        GameLogic game = initGameWithTwoPlayers();
        game.start();
        
        List<Player> allPlayers = game.getAllPlayers();
        Player player1 = allPlayers.get(0);
        Player player2 = allPlayers.get(1);
        
        player1.setHandsign(Sign.SCISSORS);
        player2.setHandsign(Sign.ROCK);
        
        game.nextRound();
        
        assertThat(player1.getScore(), is(0));
        assertThat(player2.getScore(), is(1));
    }
    
    @Test
    public void scissorsBeatsPaper() throws NotEnoughPlayersException {
        GameLogic game = initGameWithTwoPlayers();
        game.start();
        
        List<Player> allPlayers = game.getAllPlayers();
        Player player1 = allPlayers.get(0);
        Player player2 = allPlayers.get(1);
        
        player1.setHandsign(Sign.SCISSORS);
        player2.setHandsign(Sign.PAPER);
        
        game.nextRound();
        
        assertThat(player1.getScore(), is(1));
        assertThat(player2.getScore(), is(0));
    }
    
    
    
    
    
    @Test
    public void winMultipleTimes() throws NotEnoughPlayersException {
        GameLogic game = initGameWithTwoPlayers();
        game.start();
        
        List<Player> allPlayers = game.getAllPlayers();
        Player player1 = allPlayers.get(0);
        Player player2 = allPlayers.get(1);
        
        player1.setHandsign(Sign.SCISSORS);
        player2.setHandsign(Sign.PAPER);
        
        game.nextRound();
        game.nextRound();
        game.nextRound();
        game.nextRound();
        game.nextRound();
        
        assertThat(player1.getScore(), is(5));
        assertThat(player2.getScore(), is(0));
    }
    
    @Test
    public void winHalfTheTimes() throws NotEnoughPlayersException {
        GameLogic game = initGameWithTwoPlayers();
        game.start();
        
        List<Player> allPlayers = game.getAllPlayers();
        Player player1 = allPlayers.get(0);
        Player player2 = allPlayers.get(1);
        
        player1.setHandsign(Sign.SCISSORS);
        player2.setHandsign(Sign.PAPER);
        
        game.nextRound();
        game.nextRound();
        
        player1.setHandsign(Sign.PAPER);
        player2.setHandsign(Sign.SCISSORS);
        
        
        game.nextRound();
        game.nextRound();
        game.nextRound();
        
        player1.setHandsign(Sign.SCISSORS);
        player2.setHandsign(Sign.PAPER);
        
        game.nextRound();
        
        assertThat(player1.getScore(), is(3));
        assertThat(player2.getScore(), is(3));
    }
    
    @Test
    public void onePlayerDoesntPlay() throws NotEnoughPlayersException{
        GameLogic game = initGameWithTwoPlayers();
        game.start();
        
        List<Player> allPlayers = game.getAllPlayers();
        Player player1 = allPlayers.get(0);
        Player player2 = allPlayers.get(1);
        
        player1.setHandsign(Sign.SCISSORS);
        game.nextRound();
        
        assertThat(player1.getScore(), is(1));
        assertThat(player2.getScore(), is(0));
    }
    
    
    
    
    
    

    private GameLogic initGameWithTwoPlayers() {
        GameLogic game = new GameLogic();
        Player player1 = new Player("TestUser1");
        Player player2 = new Player("TestUser2");

        game.addPlayer(player1);
        game.addPlayer(player2);
        return game;
    }
}
