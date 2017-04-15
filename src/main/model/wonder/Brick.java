package model.wonder;

import model.player.Player;

public class Brick {
    private Player owner;

    public Player getOwner() {
        return owner;
    }

    //POOP: Player exposing interface when not needed, change to playerID?
    public Brick(Player owner) {
        this.owner = owner;
    }
}
