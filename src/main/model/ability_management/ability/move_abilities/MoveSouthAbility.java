package model.ability_management.ability.move_abilities;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.Ability;
import model.transporters.Transporter;

/**
 *
 */
public class MoveSouthAbility extends Ability {

    public MoveSouthAbility(Transporter actor, AbilityEnum abilityEnum) {
        super(actor, abilityEnum);
    }
    public MoveSouthAbility(){}

    @Override
    public String toString() {
        return "Move South";
    }
}
