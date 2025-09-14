package at.fhtw.task1.model.fields;

import at.fhtw.task1.model.Coordinate;

public class Well extends BaseField {
    public Well() {
        super();
    }

    public Well(Coordinate position) {
        super(position);
    }

    public Well(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "☸";
    }

    @Override
    public FieldType getFieldType() {
        return FieldType.WELL;
    }
}
