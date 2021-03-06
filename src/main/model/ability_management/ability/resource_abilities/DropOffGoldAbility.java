package model.ability_management.ability.resource_abilities;

import model.ability_management.ability.Ability;
import model.resources.resourceVisitor.GoldVisitor;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class DropOffGoldAbility extends Ability {

    public DropOffGoldAbility() {
    }

    @Override
    public void perform() {
        getActor().dropOffFromNode(new GoldVisitor());
    }

    @Override
    public String toString(){
        return "Drop Off Gold";
    }
}
