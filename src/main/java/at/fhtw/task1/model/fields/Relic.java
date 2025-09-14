package at.fhtw.task1.model.fields;

import at.fhtw.task1.model.Coordinate;

public class Relic extends BaseField {
    public Relic() {
        super();
    }

    public Relic(Coordinate position) {
        super(position);
    }

    public Relic(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "☥";
    }

    @Override
    public FieldType getFieldType() {
        return FieldType.RELIC;
    }
}
