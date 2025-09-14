package at.fhtw.task1.model.actors;

import at.fhtw.task1.model.Coordinate;

public class Enemy extends Actor {
    public Enemy() {
        super();
    }

    public Enemy(Coordinate position, Coordinate maxPosition) {
        super(position, maxPosition);
    }

    public Enemy(Coordinate maxPosition) {
        super(new Coordinate(0,0), maxPosition);
    }

    @Override
    public String toString() {
        return this.position.toString();
    }
}
