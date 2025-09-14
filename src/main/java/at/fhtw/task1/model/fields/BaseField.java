package at.fhtw.task1.model.fields;

import at.fhtw.task1.model.Coordinate;

public abstract class BaseField {
    protected Coordinate position;

    public BaseField() {
        this.position = new Coordinate();
    }

    public BaseField(Coordinate position) {
        this.position = position;
    }

    public BaseField(int x, int y) {
        this.position = new Coordinate(x, y);
    }

    public abstract String toString();

    public abstract FieldType getFieldType();

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }
}
