package model.ability_management.ability.move_abilities;

import model.ability_management.ability.Ability;

/**
 *
 */
public class MoveSouthEastLeftAbility extends Ability {


    public MoveSouthEastLeftAbility(){}

    @Override
    public void perform() {
        getActor().moveSouthEastLeft();
    }

    @Override
    public String toString() {
        return "Move Southeast Left";
    }
}
