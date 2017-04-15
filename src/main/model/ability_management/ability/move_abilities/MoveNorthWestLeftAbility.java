package model.ability_management.ability.move_abilities;

import model.ability_management.ability.Ability;

/**
 *
 */
public class MoveNorthWestLeftAbility extends Ability {

    public MoveNorthWestLeftAbility() {
    }

    @Override
    public void perform() {
        getActor().moveNorthWestLeft();
    }

    @Override
    public String toString() {
        return "Move Northwest Left";
    }
}
