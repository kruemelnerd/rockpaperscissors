package de.devk.dojo.rockpaperscissors.game.logic.ai;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberService {

    public int getRandomNumber() {
        return getRandomNumberForRange(0, 2);
    }

    private int getRandomNumberForRange(int start, int end) {
        return ThreadLocalRandom.current().nextInt(start, end + 1);
    }

}
