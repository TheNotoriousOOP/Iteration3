package model.ability_management.ability.resource_abilities;

import model.ability_management.ability.Ability;
import model.resources.resourceVisitor.IronVisitor;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class DropOffIronAbility extends Ability {

    public DropOffIronAbility() {
    }

    @Override
    public void perform() {
        getActor().dropOffFromNode(new IronVisitor());
    }

    @Override
    public String toString(){
        return "Drop Off Iron";
    }
}
