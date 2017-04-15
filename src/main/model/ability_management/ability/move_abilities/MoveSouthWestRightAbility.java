package model.ability_management.ability.move_abilities;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.Ability;
import model.transporters.Transporter;

/**
 *
 */
public class MoveSouthWestRightAbility extends Ability {

    public MoveSouthWestRightAbility(Transporter actor, AbilityEnum abilityEnum) {
        super(actor, abilityEnum);
    }

    public MoveSouthWestRightAbility(){

    }

    @Override
    public String toString() {
        return "Move Southwest Right";
    }
}
