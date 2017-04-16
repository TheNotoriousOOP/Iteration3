package model.ability_management.ability.move_abilities;

import model.ability_management.ability.Ability;

/**
 *
 */
public class MoveNorthRightAbility extends Ability {

    public MoveNorthRightAbility() {
    }

    @Override
    public void perform() {
        getActor().moveNorthRight();
    }

    @Override
    public String toString() {
        return "Move North Right";
    }
}
