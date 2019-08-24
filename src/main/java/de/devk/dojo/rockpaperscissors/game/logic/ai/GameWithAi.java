package de.devk.dojo.rockpaperscissors.game.logic.ai;

import de.devk.dojo.rockpaperscissors.game.logic.GameLogic;
import de.devk.dojo.rockpaperscissors.game.logic.NotEnoughPlayersException;
import de.devk.dojo.rockpaperscissors.model.Player;

public class GameWithAi extends GameLogic{

    final Ai ai;
    Player aiPlayer;
    
    public GameWithAi(Ai ai) {
        this.ai = ai;
        this.aiPlayer = ai.generateNewUser();
        this.addPlayer(aiPlayer);
    }

    @Override
    public void nextRound() throws NotEnoughPlayersException {
        this.ai.chooseSign(this.getAllPlayers().get(1));
        super.nextRound();
    }
}
