package de.devk.dojo.rockpaperscissors.game.logic;

public enum Sign {
//    PAPER, ROCK, SCISSORS, LIZARD, SPOCK;
    PAPER(0), ROCK(1), SCISSORS(2);

    int id;
    
    private Sign(int id) {
        this.id = id;
    }
    
    
    public boolean winsAgainst(Sign signFrom2) {

        if (signFrom2 == null) {
            return true;
        }

//        switch (this) {
//        case PAPER:
//            if (signFrom2 == ROCK || signFrom2 == SPOCK) {
//                return true;
//            }
//            return false;
//        case ROCK:
//            if (signFrom2 == SCISSORS || signFrom2 == LIZARD) {
//                return true;
//            }
//            return false;
//
//        case SCISSORS:
//            if (signFrom2 == PAPER || signFrom2 == LIZARD) {
//                return true;
//            }
//            return false;
//        case LIZARD:
//            if (signFrom2 == PAPER || signFrom2 == SPOCK) {
//                return true;
//            }
//            return false;
//        case SPOCK:
//            if (signFrom2 == SCISSORS || signFrom2 == ROCK) {
//                return true;
//            }
//            return false;
//
//        default:
//            throw new AssertionError("Unkown Operation: " + this);
//        }

        switch (this) {
        case PAPER:
            if (signFrom2 == ROCK) {
                return true;
            }
            return false;
        case ROCK:
            if (signFrom2 == SCISSORS) {
                return true;
            }
            return false;

        case SCISSORS:
            if (signFrom2 == PAPER) {
                return true;
            }
            return false;
        }
        return false;
    }
    
    public static Sign valueOf(int id) {
        for (Sign sign : Sign.values()) {
            if(sign.getId() == id) {
                return sign;
            }
        }
        throw new IllegalArgumentException("No constant with id " + id + " found");
    }
    
    public int getId() {
        return this.id;
    }
}
