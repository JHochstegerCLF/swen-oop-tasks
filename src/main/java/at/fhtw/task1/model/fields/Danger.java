package at.fhtw.task1.model.fields;

import at.fhtw.task1.model.Coordinate;

public class Danger extends BaseField {
    public Danger() {
        super();
    }

    public Danger(Coordinate position) {
        super(position);
    }

    public Danger(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "☠";
    }

    @Override
    public FieldType getFieldType() {
        return FieldType.DANGER;
    }
}
