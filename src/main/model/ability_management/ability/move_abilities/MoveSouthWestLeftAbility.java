package model.ability_management.ability.move_abilities;

import model.ability_management.ability.Ability;

/**
 *
 */
public class MoveSouthWestLeftAbility extends Ability {



    public MoveSouthWestLeftAbility(){

    }

    @Override
    public void perform() {
        getActor().moveSouthWestLeft();
    }

    @Override
    public String toString() {
        return "Move Southwest Left";
    }
}
