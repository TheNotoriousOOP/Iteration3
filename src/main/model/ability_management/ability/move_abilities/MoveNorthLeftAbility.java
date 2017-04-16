package model.ability_management.ability.move_abilities;

import model.ability_management.ability.Ability;

/**
 *
 */
public class MoveNorthLeftAbility extends Ability {

    public MoveNorthLeftAbility() {
    }

    @Override
    public void perform() {
        getActor().moveNorthLeft();
    }

    @Override
    public String toString() {
        return "Move North Left";
    }
}
