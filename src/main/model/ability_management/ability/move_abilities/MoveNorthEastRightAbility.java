package model.ability_management.ability.move_abilities;

import model.ability_management.ability.Ability;

/**
 *
 */
public class MoveNorthEastRightAbility extends Ability {

    public MoveNorthEastRightAbility() {
    }

    @Override
    public void perform() {
        getActor().moveNorthEastRight();
    }

    @Override
    public String toString() {
        return "Move Northeast Right";
    }
}
