package de.devk.dojo.rockpaperscissors.game.logic;

import java.util.ArrayList;
import java.util.List;

import de.devk.dojo.rockpaperscissors.model.Player;

public class GameLogic {
    
    List<Player> allPlayer;

    public void addPlayer(Player player) {
        if(allPlayer == null) {
            allPlayer = new ArrayList<>();
        }
        allPlayer.add(player);
    }

    public List<Player> getAllPlayers() {
        return allPlayer;
    }

    public void start() {
        allPlayer.stream().forEach(player -> player.resetScore());
        
    }

    public void nextRound() throws NotEnoughPlayersException{
        if(allPlayer == null || allPlayer.size() <= 1) {
            throw new NotEnoughPlayersException("Please add at least two players.");
        }
        Sign signFrom1 = allPlayer.get(0).getHandsign();
        Sign signFrom2 = allPlayer.get(1).getHandsign();
        
        if(signFrom1 == null && signFrom2 == null) {
            return;
        }
        
        if(signFrom1.winsAgainst(signFrom2)) {
            allPlayer.get(0).roundWon();
        }else if(signFrom2.winsAgainst(signFrom1)) {
            allPlayer.get(1).roundWon();
        }
    }

}
