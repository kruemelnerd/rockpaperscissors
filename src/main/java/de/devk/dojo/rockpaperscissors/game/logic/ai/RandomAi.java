package de.devk.dojo.rockpaperscissors.game.logic.ai;

import de.devk.dojo.rockpaperscissors.game.logic.Sign;
import de.devk.dojo.rockpaperscissors.model.Player;

public class RandomAi implements Ai {

    RandomNumberService randomNumberService;

    public RandomAi(RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    @Override
    public Player generateNewUser() {
        return new Player(this.getClass().getName(), 0 , Sign.ROCK);
    }

    @Override
    public void chooseSign(Player aiPlayer) {
        Sign sign = Sign.valueOf(randomNumberService.getRandomNumber());
        aiPlayer.setHandsign(sign);

    }

}
