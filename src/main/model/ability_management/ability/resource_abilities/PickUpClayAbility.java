package model.ability_management.ability.resource_abilities;

import model.ability_management.ability.Ability;
import model.resources.resourceVisitor.ClayVisitor;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class PickUpClayAbility extends Ability {

    public PickUpClayAbility() {
    }

    @Override
    public void perform() {
        getActor().pickupFromNode(new ClayVisitor());
    }

    @Override
    public String toString(){
        return "Pick Up Clay";
    }
}
