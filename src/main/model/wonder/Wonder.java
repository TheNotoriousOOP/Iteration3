package model.wonder;

import model.player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class Wonder {

    private List<Brick> bricks;
    private List<WonderObserver> WonderObservers;
    private HashMap<Player, Integer> playerModifierHash;
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
        playerModifierHash = new HashMap<Player, Integer>(2);
        addObserver(new CostObserver());
    }

    public void build(Player player){
        bricks.add(new Brick(player));
        Integer t = playerModifierHash.get(player);
        playerModifierHash.replace(player, t + 1);
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

    public int getBrickCost(Player player){
        if(!playerModifierHash.containsKey(player))
            playerModifierHash.put(player, 0);
        return getTier() + costModifer + playerModifierHash.get(player);
    }

    public int getWonderScore(Player player){
        //TODO implement
        return 0;
    }

    public void addObserver(WonderObserver w) {
        WonderObservers.add(w);
    }

    public void phaseStart() {
        playerModifierHash.replaceAll((player, integer) -> 0);
    }

    private void updateObservers() {
        for(WonderObserver w : WonderObservers)
            w.update(this);
    }
}
