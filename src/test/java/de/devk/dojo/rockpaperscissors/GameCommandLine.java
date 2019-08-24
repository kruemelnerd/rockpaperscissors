package de.devk.dojo.rockpaperscissors;

import de.devk.dojo.rockpaperscissors.server.frontend.GameFrontend;

public class GameCommandLine implements GameFrontend {

    @Override
    public void startNewGame() {
        System.out.println("#### New Game ####");
        System.out.println("Please enter Name for Player One: ");
        //System.in.

    }

}
