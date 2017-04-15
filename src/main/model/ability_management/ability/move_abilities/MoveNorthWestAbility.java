package model.ability_management.ability.move_abilities;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.Ability;
import model.transporters.Transporter;

/**
 *
 */
public class MoveNorthWestAbility extends Ability {

    public MoveNorthWestAbility(Transporter actor, AbilityEnum abilityEnum) {
        super(actor, abilityEnum);
    }

    public MoveNorthWestAbility() {
    }

    @Override
    public String toString() {
        return "Move Northwest";
    }
}
