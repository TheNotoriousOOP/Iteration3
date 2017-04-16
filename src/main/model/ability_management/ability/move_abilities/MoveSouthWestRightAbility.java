package model.ability_management.ability.move_abilities;

import model.ability_management.ability.Ability;

/**
 *
 */
public class MoveSouthWestRightAbility extends Ability {


    public MoveSouthWestRightAbility(){

    }

    @Override
    public void perform() {
        getActor().moveSouthWestRight();
    }

    @Override
    public String toString() {
        return "Move Southwest Right";
    }
}
