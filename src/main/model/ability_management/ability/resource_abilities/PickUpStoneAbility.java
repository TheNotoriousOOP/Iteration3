package model.ability_management.ability.resource_abilities;

import model.ability_management.AbilityEnum;
import model.ability_management.ability.Ability;
import model.transporters.Transporter;

/**
 * Created by TheNotoriousOOP on 4/12/2017.
 * Class Description:
 * Responsibilities:
 */
public class PickUpStoneAbility extends Ability {

    public PickUpStoneAbility(Transporter actor, AbilityEnum abilityEnum) {
        super(actor, abilityEnum);
    }
}
