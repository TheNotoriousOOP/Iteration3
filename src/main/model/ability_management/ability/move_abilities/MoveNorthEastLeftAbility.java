package model.ability_management.ability.move_abilities;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.Ability;
import model.transporters.Transporter;

/**
 *
 */
public class MoveNorthEastLeftAbility extends Ability {

    public MoveNorthEastLeftAbility(Transporter actor, AbilityEnum abilityEnum) {
        super(actor, abilityEnum);
    }

    public MoveNorthEastLeftAbility() {
    }

    @Override
    public String toString() {
        return "Move Northeast Left";
    }
}
