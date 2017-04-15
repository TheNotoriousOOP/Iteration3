package model.ability_management.ability.resource_abilities;

import model.ability_management.ability.Ability;
import model.resources.resourceVisitor.GoldVisitor;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class PickUpGoldAbility extends Ability {

    public PickUpGoldAbility() {
    }

    @Override
    public void perform() {
        getActor().pickupFromNode(new GoldVisitor());
    }

    @Override
    public String toString(){
        return "Pick Up Gold";
    }
}
