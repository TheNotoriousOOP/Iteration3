package model.ability_management.ability.resource_abilities;

import model.ability_management.ability.Ability;
import model.resources.resourceVisitor.CoinVisitor;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class PickUpCoinAbility extends Ability {

    public PickUpCoinAbility() {
    }

    @Override
    public void perform() {
        getActor().pickupFromNode(new CoinVisitor());
    }

    @Override
    public String toString(){
        return "Pick Up Coin";
    }
}
