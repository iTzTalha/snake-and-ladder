package models;

import java.util.HashSet;
import java.util.Set;

public class Square {
    private final int number;
    private  Snake snake;
    private Ladder ladder;

    private final Set<Player> players = new HashSet<>();

    public Square(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Snake getSnake() {
        return snake;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }
}