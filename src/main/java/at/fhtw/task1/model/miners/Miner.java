package at.fhtw.task1.model.miners;

import at.fhtw.task1.model.Coordinate;
import at.fhtw.task1.model.MineShaft;

public abstract class Miner {
    protected Coordinate position;
    protected int points;

    public Miner() {
    }

    public Miner(Coordinate position) {
        this.position = position;
    }

    public abstract void move(Coordinate direction, MineShaft mineShaft);

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return String.format("Minar:\n%s | %d", position, points);
    }
}
