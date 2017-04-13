package model.temple;

import model.player.PlayerID;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class Temple {
    private Monk[] monkList;

    public void swapMonkAtFront(PlayerID playerID){
        //TODO implement
    }

    Monk getMonkAtFront(){
        return monkList[0];
    }

    public Monk[] getMonkList() {
        return monkList;
    }

    public void setMonkList(Monk[] monkList) {
        this.monkList = monkList;
    }
}
