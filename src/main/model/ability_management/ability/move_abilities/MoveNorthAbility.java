package model.ability_management.ability.move_abilities;

import model.ability_management.ability.Ability;

/**
 *
 */
public class MoveNorthAbility extends Ability {

    public MoveNorthAbility() {
    }

    @Override
    public void perform() {
        getActor().moveNorth();
    }

    @Override
    public String toString() {
        return "Move North";
    }
}
