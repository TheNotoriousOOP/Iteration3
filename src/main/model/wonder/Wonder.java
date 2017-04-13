package model.wonder;

import model.player.Player;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class Wonder {

    private Brick[] bricks;
    //private listener[] WonderListener;

    public void build(Player player){
        //TODO implement
    }

    public int getSize(){
        //TODO implement
        return bricks.length;
    }

    public int getBrickCost(){
        //TODO implement
        return 0;
    }

    public int getWonderScore(Player player){
        //TODO implement
        return 0;
    }

    public Brick[] getBricks() {
        return bricks;
    }

    public void setBricks(Brick[] bricks) {
        this.bricks = bricks;
    }
}
