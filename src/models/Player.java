package models;

import services.DiceService;

public class Player extends BaseModel {
    protected final String name;
    protected Square position;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Square getPosition() {
        return position;
    }

    public void setPosition(Square position) {
        this.position = position;
    }

    public int roll(DiceService diceService) {
        return diceService.role();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
