package model.ability_management.ability.move_abilities;

import model.ability_management.ability.Ability;

/**
 *
 */
public class MoveSouthRightAbility extends Ability {



    public MoveSouthRightAbility(){

    }

    @Override
    public void perform() {
        getActor().moveSouthRight();
    }

    @Override
    public String toString() {
        return "Move South Right";
    }
}
