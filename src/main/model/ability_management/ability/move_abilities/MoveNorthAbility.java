package model.ability_management.ability.move_abilities;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.Ability;
import model.transporters.Transporter;

/**
 *
 */
public class MoveNorthAbility extends Ability {
    public MoveNorthAbility(Transporter actor, boolean isListening, AbilityEnum abilityEnum) {
        super(actor, isListening, abilityEnum);
    }
}
