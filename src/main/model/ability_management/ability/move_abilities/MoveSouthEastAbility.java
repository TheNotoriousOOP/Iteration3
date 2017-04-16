package model.ability_management.ability.move_abilities;

import model.ability_management.ability.Ability;

/**
 *
 */
public class MoveSouthEastAbility extends Ability {


    public MoveSouthEastAbility(){}

    @Override
    public void perform() {
        getActor().moveSouthEast();
    }

    @Override
    public String toString() {
        return "Move Southeast";
    }
}
