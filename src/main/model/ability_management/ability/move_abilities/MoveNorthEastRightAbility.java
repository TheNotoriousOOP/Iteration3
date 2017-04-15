package model.ability_management.ability.move_abilities;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.Ability;
import model.transporters.Transporter;

/**
 *
 */
public class MoveNorthEastRightAbility extends Ability {

    public MoveNorthEastRightAbility(Transporter actor, AbilityEnum abilityEnum) {
        super(actor, abilityEnum);
    }

    public MoveNorthEastRightAbility() {
    }

    @Override
    public String toString() {
        return "Move Northeast Right";
    }
}
