package model.ability_management.ability.move_abilities;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.Ability;
import model.transporters.Transporter;

/**
 *
 */
public class MoveSouthRightAbility extends Ability {
    public MoveSouthRightAbility(Transporter actor, boolean isListening, AbilityEnum abilityEnum) {
        super(actor, isListening, abilityEnum);
    }
}
