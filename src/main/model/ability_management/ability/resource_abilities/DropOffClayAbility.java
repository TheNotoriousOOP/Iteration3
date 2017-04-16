package model.ability_management.ability.resource_abilities;

import model.ability_management.ability.Ability;
import model.resources.resourceVisitor.BoardVisitor;
import model.resources.resourceVisitor.ClayVisitor;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class DropOffClayAbility extends Ability {

    public DropOffClayAbility() {
    }

    @Override
    public void perform() {
        getActor().dropOffFromNode(new ClayVisitor());
    }

    @Override
    public String toString(){
        return "Drop Off Clay";
    }
}
