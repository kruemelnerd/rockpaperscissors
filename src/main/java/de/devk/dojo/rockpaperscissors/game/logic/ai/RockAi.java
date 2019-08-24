package de.devk.dojo.rockpaperscissors.game.logic.ai;

import de.devk.dojo.rockpaperscissors.game.logic.Sign;
import de.devk.dojo.rockpaperscissors.model.Player;

public class RockAi implements Ai {

    public Player generateNewUser() {
        return new Player(this.getClass().getName(), 0, Sign.ROCK);
    }

    @Override
    public void chooseSign(Player player) {
        player.setHandsign(Sign.ROCK);
    }


}
