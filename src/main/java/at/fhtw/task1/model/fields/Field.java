package at.fhtw.task1.model.fields;

import at.fhtw.task1.model.Coordinate;

public class Field extends BaseField {

    public Field() {
        super();
    }

    public Field(Coordinate position) {
        super(position);
    }

    public Field(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return ".";
    }

    @Override
    public FieldType getFieldType() {
        return FieldType.FIELD;
    }
}
