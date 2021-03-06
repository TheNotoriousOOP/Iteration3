package model.ability_management.ability.resource_abilities;

import model.ability_management.ability.Ability;
import model.resources.resourceVisitor.FuelVisitor;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class PickUpFuelAbility extends Ability {

    public PickUpFuelAbility() {
    }

    @Override
    public void perform() {
        getActor().pickupFromNode(new FuelVisitor());
    }

    @Override
    public String toString(){
        return "Pick Up Fuel";
    }
}
