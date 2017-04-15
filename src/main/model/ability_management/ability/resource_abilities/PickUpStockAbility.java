package model.ability_management.ability.resource_abilities;

import model.ability_management.ability.Ability;
import model.resources.resourceVisitor.StockVisitor;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class PickUpStockAbility extends Ability {

    public PickUpStockAbility() {
    }

    @Override
    public void perform() {
        getActor().pickupFromNode(new StockVisitor());
    }

    @Override
    public String toString(){
        return "Pick Up Stock";
    }
}
