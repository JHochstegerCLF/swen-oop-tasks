package at.fhtw.task1;

import at.fhtw.task1.model.Coordinate;
import at.fhtw.task1.model.Map;
import at.fhtw.task1.model.actors.Player;
import at.fhtw.task1.view.View;

public class TaskOne {
    public static void runTask1() {
        System.out.println("Test");
        int width = 10;
        int height = 10;
        do {
            Player player = new Player(new Coordinate(width, height), 5);
            Map map = new Map(width, height, player, 1);

            while(!isWon(player.getRelics(), map.getRelics()) ||
            !isLost(player.getHealth())) {
                View.printUI(map);
                String move = "";
                do {
                    move = View.getMove();
                } while (!isValidMove(move));
                Coordinate direction = translateMove(move);
                player.move(direction);
                switch(map.getCurrentFieldType()) {
                    case DANGER -> {
                        if ((int) (Math.random()*6) == 0) {
                            player.reduceHealth(1);
                        }
                    }
                    case RELIC -> player.increaseRelics(1);
                    case WELL -> player.increaseHealth(1);
                }
                map.clearCurrentField();
            }
            if (isWon(player.getRelics(), map.getRelics())) {
                View.showWinMessage();
            } else {
                View.showLoseMessage();
            }
        } while (View.getNewGame());
    }

    public static boolean isValidMove(String move) {
        return "hjkl".contains(move);
    }

    public static Coordinate translateMove(String move) {
        switch (move) {
            case "h" -> {return new Coordinate(0, -1);}
            case "j" -> {return new Coordinate(1, 0);}
            case "k" -> {return new Coordinate(-1, 0);}
            case "l" -> {return new Coordinate(0, 1);}
            default -> {return new Coordinate(0, 0);}
        }
    }

    public static boolean isWon(int relics, int maxRelics) {
        return relics >= maxRelics;
    }

    public static boolean isLost(int healt) {
        return healt >= 0;
    }
}
