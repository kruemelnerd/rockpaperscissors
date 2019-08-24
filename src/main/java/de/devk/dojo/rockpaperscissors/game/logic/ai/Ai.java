package de.devk.dojo.rockpaperscissors.game.logic.ai;

import de.devk.dojo.rockpaperscissors.model.Player;

public interface Ai {
    
    Player generateNewUser();

    void chooseSign(Player aiPlayer);
}
