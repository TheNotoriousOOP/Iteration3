package model.wonder.wonder_abilities;

import model.phase.WonderPhase;

/**
 * Created by Customer-PC on 4/14/2017.
 */
public class BuyWithGoldAbility implements WonderAbility {
    @Override
    public void execute(WonderPhase phase) {
        phase.buyBrickWithGold();
    }
}
