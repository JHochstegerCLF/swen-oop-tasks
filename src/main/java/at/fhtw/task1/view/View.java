package at.fhtw.task1.view;

import at.fhtw.task1.model.Map;

import java.util.Scanner;

public class View {
    public static void printUI(Map map) {
        System.out.println(map);
    }

    public static String getMove() {
        System.out.println("Please input your next move (h ←, j ↓, k ↑, l →)");
        Scanner scanner = new Scanner(System.in);
        return String.valueOf(scanner.nextLine().charAt(0));
    }

    public static boolean getNewGame() {
        System.out.println("Do you want to play again? (y/N)");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().equalsIgnoreCase("y");
    }

    public static void showWinMessage() {
        System.out.println("Congrats! You won!");
    }

    public static void showLoseMessage() {
        System.out.println("Oh no! You died!");
    }
}
