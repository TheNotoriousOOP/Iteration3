package model.ability_management.ability.wonder_abilities;

import model.ability_management.ability.Ability;
import model.phase.WonderPhase;
import model.resources.resourceVisitor.StockVisitor;
import model.transporters.Transporter;

/**
 * Created by Customer-PC on 4/14/2017.
 */
public class BuyBrickWithStockAbility extends Ability {
    private WonderPhase wonderPhase;

    public BuyBrickWithStockAbility(WonderPhase phase) {
        //super(actor, isListening);
        this.wonderPhase = phase;
    }

    public void perform() { wonderPhase.buyBrick(new StockVisitor()); }

    public String toString() {
        return "Buy Brick With Stock";
    }
}
