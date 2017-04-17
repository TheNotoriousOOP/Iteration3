package model.ability_management.ability.resource_abilities;

import model.ability_management.ability.Ability;
import model.resources.resourceVisitor.PaperVisitor;

/**
 *
 */
public class PickUpPaperAbility extends Ability {
    public PickUpPaperAbility() {
    }

    @Override
    public void perform() {
        getActor().pickupFromNode(new PaperVisitor());
    }

    @Override
    public String toString(){
        return "Pick Up Paper";
    }
}
