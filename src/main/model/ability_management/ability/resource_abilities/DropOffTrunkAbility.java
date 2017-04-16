package model.ability_management.ability.resource_abilities;

import model.ability_management.ability.Ability;
import model.resources.resourceVisitor.TrunksVisitor;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class DropOffTrunkAbility extends Ability {

    public DropOffTrunkAbility() {
    }

    @Override
    public void perform() {
        getActor().dropOffFromNode(new TrunksVisitor());
    }

    @Override
    public String toString(){
        return "Drop Off Trunk";
    }
}
