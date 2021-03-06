package model.ability_management.ability.resource_abilities;

import model.ability_management.ability.Ability;
import model.resources.resourceVisitor.StockVisitor;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class DropOffStockAbility extends Ability {

    public DropOffStockAbility() {
    }

    @Override
    public void perform() {
        getActor().dropOffFromNode(new StockVisitor());
    }

    @Override
    public String toString(){
        return "Drop Off Stock";
    }
}
