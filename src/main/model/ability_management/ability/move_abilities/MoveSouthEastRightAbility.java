package model.ability_management.ability.move_abilities;

import model.ability_management.ability.Ability;

/**
 *
 */
public class MoveSouthEastRightAbility extends Ability {


    public MoveSouthEastRightAbility(){

    }

    @Override
    public void perform() {
        getActor().moveSouthEastRight();
    }

    @Override
    public String toString() {
        return "Move Southeast Right";
    }
}
