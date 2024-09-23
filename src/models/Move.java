package models;

public class Move extends BaseModel {
    private final Square source;
    private final Square destination;
    private final Player player;

    public Move(Player player, Square source, Square destination) {
        this.source = source;
        this.destination = destination;
        this.player = player;
    }

    public Square getSource() {
        return source;
    }

    public Square getDestination() {
        return destination;
    }

    public Player getPlayer() {
        return player;
    }
}
