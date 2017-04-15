package model.ability_management.ability.move_abilities;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.Ability;
import model.transporters.Transporter;

/**
 *
 */
public class MoveNorthWestRightAbility extends Ability {

    public MoveNorthWestRightAbility(Transporter actor, AbilityEnum abilityEnum) {
        super(actor, abilityEnum);
    }

    public MoveNorthWestRightAbility() {
    }

    @Override
    public String toString() {
        return "Move Northwest Right";
    }
}
