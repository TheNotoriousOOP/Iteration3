package model.ability_management.ability.move_abilities;

import model.ability_management.ability.Ability;

/**
 *
 */
public class MoveSouthAbility extends Ability {


    public MoveSouthAbility(){}

    @Override
    public void perform() {
        getActor().moveSouth();
    }

    @Override
    public String toString() {
        return "Move South";
    }
}
