package model.ability_management.ability.move_abilities;

import model.ability_management.ability.Ability;

/**
 *
 */
public class MoveNorthWestAbility extends Ability {

    public MoveNorthWestAbility() {
    }

    @Override
    public void perform() {
        getActor().moveNorthWest();
    }

    @Override
    public String toString() {
        return "Move Northwest";
    }
}
