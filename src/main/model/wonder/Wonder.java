package model.wonder;

import model.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class Wonder {

    private List<Brick> bricks;
    private List<WonderObserver> WonderObservers;
    private int costModifer;

    private class CostObserver extends WonderObserver {
        public static final int MAGIC_TIER_NUMBER = 18;
        public CostObserver() {
            super(MAGIC_TIER_NUMBER);
        }
        protected void trigger() { costModifer =+ 1; }
    }

    public Wonder() {
        bricks = new ArrayList<Brick>(62);
        WonderObservers = new ArrayList<WonderObserver>(3);
        addObserver(new CostObserver());
    }

    public void build(Player player){
        bricks.add(new Brick(player));
    }

    public void build() {
        bricks.add(new Brick(null));
    }

    public int getSize(){
        return bricks.size();
    }

    public int getTier() {
        int size = bricks.size();
        int brick = 4;
        int tier = 1;
        int prevTiers = 0;
        while(size > 0) {
            size -= brick;
            tier++;
            if(brick + prevTiers == tier) {
                prevTiers += tier;
                brick++;
            }
        }
        return tier; //FuckMyMathUp
    }

    public int getBrickCost(){
        return getTier() + costModifer;
    }

    public int getWonderScore(Player player){
        //TODO implement
        return 0;
    }

    public void addObserver(WonderObserver w) {
        WonderObservers.add(w);
    }

    private void updateObservers() {
        for(WonderObserver w : WonderObservers)
            w.update(this);
    }
}
