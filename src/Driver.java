import models.Game;
import models.Ladder;
import models.Player;
import models.Snake;

import java.util.*;

public class Driver {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        System.out.print("Enter player count: ");
        final int playerCount = sc.nextInt();
        sc.nextLine();

        final Deque<Player> players = new ArrayDeque<>(playerCount);
        for (int i = 1; i <= playerCount; i++) {
            System.out.print("Enter player " + i + " name: ");
            players.add(new Player(sc.next()));
        }

        System.out.print("Enter snake count: ");
        final int snakeCount = sc.nextInt();
        sc.nextLine();

        Map<Integer, Snake> snakes = new HashMap<>();
        String[] input;
        int start, end;

        for (int i = 1; i <= snakeCount; i++) {
            do {
                System.out.print("Enter snake " + i + " positions: ");
                input = sc.nextLine().split("\\s");

                start = Integer.parseInt(input[0]);
                end = Integer.parseInt(input[1]);

                if (start <= 1 || start >= 100) {
                    System.out.println("Start position can't be " + start);
                } else if (start <= end) {
                    System.out.println("Start can't be less or equal to end position");
                } else if (end < 1) {
                    System.out.println("End position can't be " + end);
                } else if (snakes.containsKey(start)) {
                    System.out.println("Snake already present");
                }
            } while (end < 1 || start <= 1 || start >= 100 || start <= end || snakes.containsKey(start));

            Snake snake = new Snake(start, end);
            snakes.put(snake.getStart(), snake);
        }

        System.out.print("Enter ladder count: ");
        final int ladderCount = sc.nextInt();
        sc.nextLine();

        Map<Integer, Ladder> ladders = new HashMap<>();
        for (int i = 1; i <= ladderCount; i++) {
            do {
                System.out.print("Enter ladder " + i + " positions: ");
                input = sc.nextLine().split("\\s");

                start = Integer.parseInt(input[0]);
                end = Integer.parseInt(input[1]);

                if (start <= 1 || start >= 100) {
                    System.out.println("Start position can't be " + start);
                } else if (end <= start) {
                    System.out.println("End can't be less or equal to start position");
                } else if (end > 100) {
                    System.out.println("End position can't be " + end);
                } else if (ladders.containsKey(start)) {
                    System.out.println("Ladder already present");
                } else if (snakes.containsKey(start)) {
                    System.out.println("Snake already present, can't start ladder from here");
                } else if (snakes.containsKey(end)) {
                    System.out.println("Snake at " + end);
                }
            } while (end > 100 || start <= 1 || start >= 100 || end <= start || ladders.containsKey(start) || snakes.containsKey(start) || snakes.containsKey(end));

            Ladder ladder = new Ladder(start, end);
            ladders.put(ladder.getStart(), ladder);
        }

        Game game = new Game(100, 1, new HashSet<>(snakes.values()), new HashSet<>(ladders.values()), players);

        game.start();
    }
}
