package de.devk.dojo.rockpaperscissors.game.logic;

public class NotEnoughPlayersException extends Exception {

    public NotEnoughPlayersException() {
        super();
    }
    
    public NotEnoughPlayersException(String message) {
        super(message);
    }
}
