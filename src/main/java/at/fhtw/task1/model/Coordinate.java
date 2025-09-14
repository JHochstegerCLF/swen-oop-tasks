package at.fhtw.task1.model;

import java.util.Objects;

public class Coordinate {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Coordinate() {
        this.x = 0;
        this.y = 0;
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate add(Coordinate other) {
        return new Coordinate(this.x + other.getX(), this.y + other.getY());
    }

    public void addEqual(Coordinate other) {
        this.x += other.getX();
        this.y += other.getY();
    }

    public Coordinate subtract(Coordinate other) {
        return new Coordinate(this.x - other.getX(), this.y - other.getY());
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", this.x, this.y);
    }

    public boolean equals(Coordinate other) {
        return x == other.x && y == other.y;
    }

    public void subtractEqual(Coordinate other) {
        this.x -= other.getX();
        this.y -= other.getY();
    }

    public Coordinate mod(Coordinate other) {
        return new Coordinate(this.x % other.getX(), this.y % other.getY());
    }

    public static final Coordinate NORTH = new Coordinate(0,1);
    public static final Coordinate EAST = new Coordinate(1,0);
    public static final Coordinate SOUTH = new Coordinate(0,-1);
    public static final Coordinate WEST = new Coordinate(-1,0);
}
