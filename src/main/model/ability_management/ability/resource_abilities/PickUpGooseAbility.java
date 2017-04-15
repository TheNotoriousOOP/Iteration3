package model.ability_management.ability.resource_abilities;

import model.ability_management.ability.Ability;
import model.resources.resourceVisitor.GooseVisitor;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class PickUpGooseAbility extends Ability {

    public PickUpGooseAbility() {
    }

    @Override
    public void perform() {
        getActor().pickupFromNode(new GooseVisitor());
    }

    @Override
    public String toString(){
        return "Pick Up Goose";
    }
}
