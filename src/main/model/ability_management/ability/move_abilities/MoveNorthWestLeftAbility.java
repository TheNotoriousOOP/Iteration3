package model.ability_management.ability.move_abilities;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.Ability;
import model.transporters.Transporter;

/**
 *
 */
public class MoveNorthWestLeftAbility extends Ability {

    public MoveNorthWestLeftAbility(Transporter actor, AbilityEnum abilityEnum) {
        super(actor, abilityEnum);
    }

    public MoveNorthWestLeftAbility() {
    }

    @Override
    public String toString() {
        return "Move Northwest Left";
    }
}
