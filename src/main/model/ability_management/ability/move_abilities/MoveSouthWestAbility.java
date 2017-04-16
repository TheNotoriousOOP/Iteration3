package model.ability_management.ability.move_abilities;

import model.ability_management.ability.Ability;

/**
 *
 */
public class MoveSouthWestAbility extends Ability {



    public MoveSouthWestAbility(){

    }

    @Override
    public void perform() {
        getActor().moveSouthWest();
    }

    @Override
    public String toString() {
        return "Move Southwest";
    }
}
