package model.ability_management.ability.resource_abilities;

import model.ability_management.ability.Ability;
import model.resources.resourceVisitor.PaperVisitor;

/**
 * Created by David on 4/15/2017.
 */
public class DropOffPaperAbility extends Ability {
    public DropOffPaperAbility() {
    }

    @Override
    public void perform() {
        getActor().dropOffFromNode(new PaperVisitor());
    }

    @Override
    public String toString(){
        return "Drop Off Paper";
    }
}
