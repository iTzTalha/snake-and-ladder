package models;

import enums.GameStatus;
import services.DiceService;

import java.util.*;

public class Game extends BaseModel {
     public static class Builder {
        private int size;
        private int diceCount;
        private Set<Snake> snakes;
        private Set<Ladder> ladders;
        private Deque<Player> players;

        public Builder setBoardSize(int size) {
            this.size = size;
            return this;
        }

        public Builder setDiceCount(int count) {
            this.diceCount = count;
            return this;
        }

        public Builder setPlayers(Deque<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setSnakes(Set<Snake> snakes) {
            this.snakes = snakes;
            return this;
        }

        public Builder setLadder(Set<Ladder> ladders) {
            this.ladders = ladders;
            return this;
        }

        public Game build() {
            return new Game(size, diceCount, snakes, ladders, players);
        }
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    private final Board board;
    private final Deque<Player> players;
    private GameStatus gameStatus;
    private final Set<Player> winners;
    private final List<Move> moves;
    private final DiceService diceService;

    private Game(int boardSize, int diceCount, Set<Snake> snakes, Set<Ladder> ladders, Deque<Player> players) {
        this.board = new Board(boardSize, snakes, ladders);
        this.diceService = new DiceService(diceCount);
        this.players = players;
        players.forEach(player -> {
            Square square = board.getSquares()[1];
            square.addPlayer(player);
            player.setPosition(square);
        });
        this.gameStatus = GameStatus.STARTED;
        this.winners = new LinkedHashSet<>();
        this.moves = new ArrayList<>();
    }

    public void start() {
        gameStatus = GameStatus.RUNNING;

        while (!players.isEmpty()) {
            Player player = players.poll();

            if (player != null) {
                Square source = player.getPosition();
                if (source != null) {
                    int position = player.roll(diceService) + source.getNumber();
                    if (position <= 100) {
                        Square destination = board.getSquares()[position];

                        if (destination != null) {
                            if (destination.getSnake() != null) {
                                destination = board.getSquares()[destination.getSnake().getEnd()];
                            } else if (destination.getLadder() != null) {
                                destination = board.getSquares()[destination.getLadder().getEnd()];
                            }

                            source.removePlayer(player);

                            destination.addPlayer(player);
                            player.setPosition(destination);

                            moves.add(new Move(player, source, destination));

                            if (destination.getNumber() < 100) {
                                players.offer(player);
                            } else {
                                winners.add(player);
                            }
                        }
                    } else {
                        players.offer(player);
                    }
                }
            }
        }

        gameStatus = GameStatus.OVER;

        System.out.println("========== WINNERS ==========");
        int i = 1;
        for (Player player : winners) {
            System.out.println("Rank " + i + 1 + ": " + player.getName());
        }
    }
}
