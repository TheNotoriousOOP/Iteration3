package model.ability_management.ability.move_abilities;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.Ability;
import model.transporters.Transporter;

/**
 *
 */
public class MoveNorthEastAbility extends Ability {
    public MoveNorthEastAbility(Transporter actor, boolean isListening, AbilityEnum abilityEnum) {
        super(actor, isListening, abilityEnum);
    }
}
