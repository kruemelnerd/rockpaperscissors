package de.devk.dojo.rockpaperscissors.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import de.devk.dojo.rockpaperscissors.game.logic.Sign;

@Entity
public class Player {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private int score;
    private Sign handsign;

    public Player() {
        // Needed for Hibernate :(
    }

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int score, Sign handsign) {
        this.name = name;
        this.score = score;
        this.handsign = handsign;
    }

//    public Player(Builder builder) {
//        this.name = builder.name;
//        this.score = 0;
//
//    }
//
//    public static class Builder {
//
//        private String name;
//
//        public Builder withName(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public Player build() {
//            return new Player(this);
//        }
//
//    }

    public void resetScore() {
        score = 0;
    }

    public void roundWon() {
        this.score++;
    }


    // GETTER & SETTER

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Sign getHandsign() {
        return handsign;
    }

    public void setHandsign(Sign handsign) {
        this.handsign = handsign;
    }

}
