package at.fhtw.task1.model;

import at.fhtw.task1.model.actors.Enemy;
import at.fhtw.task1.model.actors.Player;
import at.fhtw.task1.model.fields.*;

import java.util.ArrayList;

public class Map {
    private ArrayList<ArrayList<BaseField>> map;
    private Player player;
    private int danger;
    private int well;
    private int relic;
    private ArrayList<Enemy> enemies;

    public Map(int width, int height, Player player, int enemyAmount) {
        this.player = player;
        this.map = new ArrayList<>();
        for (int x = 0; x < width; x++) {
            this.map.add(new ArrayList<>());
            for (int y = 0; y < height; y++) {
                BaseField field = this.getRandomField(new Coordinate(x, y));
                this.map.getLast().add(field);
                switch(field.getFieldType()) {
                    case DANGER -> this.danger++;
                    case WELL -> this.well++;
                    case RELIC -> this.relic++;
                }
            }
        }
        this.enemies = new ArrayList<>();
        for (int i = 0; i < enemyAmount; i++) {
            this.enemies.add(new Enemy(this.getRandomClearField().getPosition(), new Coordinate(width, height)));
        }
    }

    public BaseField getRandomField(Coordinate position) {
        switch((int) (Math.random() * 10)) {
            case 4, 5, 6, 7 -> {return new Danger(position);}
            case 8 -> {return new Well(position);}
            case 9 -> {return new Relic(position);}
            default -> {return new Field(position);} // so 0, 1, 2, 3
        }
    }

    public BaseField getRandomClearField() {
        while(true) {
            BaseField field = map.get((int)(Math.random()*(map.size()))).get((int)(Math.random()*(map.getFirst().size())));
            if(
                field.getFieldType() == FieldType.FIELD &&
                !field.getPosition().equals(new Coordinate(0,0)) &&
                this.enemies.stream().noneMatch(e -> e.getPosition().equals(field.getPosition()))
            ) {
                System.out.println("found");
                return field;
            }
        }
    }

    public void clearCurrentField() {
        Coordinate position = this.player.getPosition();
        map.get(position.getX()).set(position.getY(), new Field(position));
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        for (ArrayList<BaseField> fields : map) {
            for (BaseField field : fields) {
                if (field.getPosition().equals(this.player.getPosition())) {
                    output.append("x");
                } else if (this.enemies.stream().anyMatch(
                        e -> e.getPosition().equals(field.getPosition())
                )) {
                    output.append("!");
                } else {
                    output.append(field);
                }
            }
            output.append("\n");
        }
        output.append("\n");
        output.append(player);
        return output.toString();
    }

    public int getRelics() {
        return this.relic;
    }

    public Player getPlayer() {
        return this.player;
    }

    public FieldType getCurrentFieldType() {
        return map.get(this.player.getPosition().getX()).get(this.player.getPosition().getY()).getFieldType();
    }
}
