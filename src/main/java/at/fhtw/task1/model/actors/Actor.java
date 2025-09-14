package at.fhtw.task1.model.actors;

import at.fhtw.task1.model.Coordinate;

public abstract class Actor {
    protected Coordinate position;
    protected Coordinate maxPosition;

    Actor() {
        this.position = new Coordinate(0, 0);
        this.maxPosition = new Coordinate(1, 1);
    }

    Actor(Coordinate position, Coordinate maxPosition) {
        this.position = position;
        this.maxPosition = maxPosition;
    }

    Actor(int x, int y, int maxX, int maxY) {
        this.position = new Coordinate(x, y);
        this.maxPosition = new Coordinate(maxX, maxY);
    }

    public abstract String toString();

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public void move(Coordinate direction) {
        this.position = this.position.add(direction).add(this.maxPosition).mod(this.maxPosition);
    }
}
