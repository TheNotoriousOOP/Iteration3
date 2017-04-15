package model.ability_management.ability.resource_abilities;

import model.ability_management.ability.Ability;
import model.resources.resourceVisitor.StoneVisitor;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class PickUpStoneAbility extends Ability {

    public PickUpStoneAbility() {
    }

    @Override
    public void perform() {
        getActor().pickupFromNode(new StoneVisitor());
    }

    @Override
    public String toString(){
        return "Pick Up Stone";
    }
}
