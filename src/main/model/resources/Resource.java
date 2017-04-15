package model.resources;

import model.player.PlayerID;

import java.util.HashSet;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public abstract class Resource {
    private HashSet<PlayerID> movedPlayers;

    public Resource() {
        this.movedPlayers = new HashSet<PlayerID>();
    }

    abstract void addToStorage(ResourceStorage storage);

    void setMovedByPlayer(PlayerID playerID){
        //TODO implement
    }

    boolean playerCanMove(PlayerID playerID){
        //TODO implement
        return true;
    }

    void onMovementTurnEnded(){
        //TODO see if anything else needs to be in this function
        movedPlayers.clear();
    }

    public HashSet<PlayerID> getMovedPlayers() {
        return movedPlayers;
    }

    public void setMovedPlayers(HashSet<PlayerID> movedPlayers) {
        this.movedPlayers = movedPlayers;
    }
}
