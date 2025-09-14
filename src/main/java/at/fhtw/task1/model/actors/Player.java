package at.fhtw.task1.model.actors;

import at.fhtw.task1.model.Coordinate;

public class Player extends Actor {
    protected int health;
    protected int relics;

    public Player() {
        super();
        this.health = 0;
        this.relics = 0;
    }

    public Player(Coordinate position, Coordinate maxPosition, int health, int relics) {
        super(position, maxPosition);
        this.health = health;
        this.relics = relics;
    }

    public Player(Coordinate position, Coordinate maxPosition, int health) {
        super(position, maxPosition);
        this.health = health;
        this.relics = 0;
    }

    public Player(Coordinate maxPosition, int health) {
        super(new Coordinate(0,0), maxPosition);
        this.health = health;
        this.relics = 0;
    }

    @Override
    public String toString() {
        return this.position + " Health: " + this.health + " Relics: " + this.relics;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getRelics() {
        return relics;
    }

    public void increaseRelics(int relic) {
        this.relics+=relic;
    }

    public void increaseHealth(int health) {
        this.health+=health;
    }

    public void reduceHealth(int damage) {
        this.health-=damage;
    }
}
