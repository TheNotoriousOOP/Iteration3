package model.ability_management.ability.move_abilities;

import model.ability_management.ability.Ability;

/**
 *
 */
public class MoveNorthEastAbility extends Ability {

    public MoveNorthEastAbility() {
    }

    @Override
    public void perform() {
        getActor().moveNorthEast();
    }

    @Override
    public String toString() {
        return "Move Northeast";
    }
}
