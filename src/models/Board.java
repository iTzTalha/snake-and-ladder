package models;

import java.util.Set;

public class Board {
    private final Square[] squares;

    public Board(int size, Set<Snake> snakes, Set<Ladder> ladders) {
        this.squares = new Square[size+1];
        for(int i = 1; i <= size; i++) {
            this.squares[i] = new Square(i);
        }

        snakes.forEach(snake -> squares[snake.getStart()].setSnake(snake));
        ladders.forEach(ladder -> squares[ladder.getStart()].setLadder(ladder));
    }

    public Square[] getSquares() {
        return squares;
    }
}