package model.ability_management.ability.resource_abilities;

import model.ability_management.ability.Ability;
import model.resources.resourceVisitor.GoldVisitor;
import model.resources.resourceVisitor.GooseVisitor;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class DropOffGooseAbility extends Ability {

    public DropOffGooseAbility() {
    }

    @Override
    public void perform() {
        getActor().dropOffFromNode(new GooseVisitor());
    }

    @Override
    public String toString(){
        return "Drop Off Goose";
    }
}
