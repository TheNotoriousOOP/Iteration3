package model.temple;

import model.player.PlayerID;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class Temple {
    private Monk[] monkList;

    public Temple(Monk monk1, Monk monk2) {
        this.monkList = new Monk[2];
        this.monkList[0] = monk1;
        this.monkList[1] = monk2;

    }

    public void swapMonkAtFront(){
        Monk m = getMonkAtFront();
        monkList[0] = monkList[1];
        monkList[1] = m;
    }

    public Monk getMonkAtFront(){
        return monkList[0];
    }

    public Monk[] getMonkList() {
        return monkList;
    }

}
